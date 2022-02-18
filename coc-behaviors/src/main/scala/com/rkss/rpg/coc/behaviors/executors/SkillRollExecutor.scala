package com.rkss.rpg.coc.behaviors.executors

import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.commons._
import com.rkss.rpg.coc.concepts.results._

private[behaviors] class SkillRollExecutor private () {
  def roll[A <: Naming](
      rollable: EntityWithDifficultyValue with EntityWithNameTag[A],
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice
  )(rng: Either[SkillRollDiceResult, HundredSidedDice]): SkillRolled[A] = {
    val required = rollable.value(difficulty)

    val regular = rollable.value()
    val hard = regular / 2
    val extreme = regular / 5

    val fumble = if (required < 50) 96 else 100

    val rolled = rng match {
      case Left(diceRolled) => diceRolled
      case Right(hundredSidedDice) =>
        rollDice(bonusDice, penaltyDice)(hundredSidedDice)
    }

    val result = rolled.value match {
      case 1                                   => SkillRollCriticalSuccess
      case diceResult if diceResult >= fumble  => SkillRollFumble
      case diceResult if diceResult > required => SkillRollFailure
      case diceResult if diceResult <= extreme => SkillRollExtremeSuccess
      case diceResult if diceResult <= hard    => SkillRollHardSuccess
      case diceResult if diceResult <= regular => SkillRollRegularSuccess
    }

    SkillRolled[A](
      rollable.name,
      required,
      difficulty,
      bonusDice,
      penaltyDice,
      result,
      rolled
    )
  }

  private def rollDice(bonusDice: BonusDice, penaltyDice: PenaltyDice)(implicit
      hundredSidedDice: HundredSidedDice
  ): SkillRollDiceResult = {
    val diff = bonusDice.value - penaltyDice.value

    val dice = 1 + Math.abs(diff)

    val rolled = (1 to dice).map(_ => hundredSidedDice.roll).sortBy(_.value)

    if (diff < 0) {
      val tmp = rolled.reverse

      SkillRollDiceResult(tmp.head.value, tmp.tail.map(_.value))
    } else {
      SkillRollDiceResult(rolled.head.value, rolled.tail.map(_.value))
    }
  }
}

private[behaviors] object SkillRollExecutor {
  lazy val instance: SkillRollExecutor = {
    new SkillRollExecutor
  }
}
