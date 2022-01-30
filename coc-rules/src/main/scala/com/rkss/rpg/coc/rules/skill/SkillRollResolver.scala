package com.rkss.rpg.coc.rules.skill

import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts._

private class SkillRollResolver private () {
  def roll[A <: NameTag](
      rollable: EntityWithDifficultyValue with EntityWithNameTag[A],
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice
  )(implicit hundredSidedDice: HundredSidedDice): SkillRolled[A] = {
    val regular = rollable.value(difficulty)
    val hard = regular / 2
    val extreme = regular / 5

    val fumble = if (regular < 50) 96 else 100

    val rolled = rollDice(bonusDice, penaltyDice)

    val result = rolled.value match {
      case 1                                   => CriticalSuccess
      case diceResult if diceResult >= fumble  => Fumble
      case diceResult if diceResult <= extreme => ExtremeSuccess
      case diceResult if diceResult <= hard    => HardSuccess
      case diceResult if diceResult <= regular => RegularSuccess
      case _                                   => Failure
    }

    SkillRolled[A](
      rollable.name,
      regular,
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

private object SkillRollResolver {
  lazy val instance: SkillRollResolver = {
    new SkillRollResolver
  }
}
