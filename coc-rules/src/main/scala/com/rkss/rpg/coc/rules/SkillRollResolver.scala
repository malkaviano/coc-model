package com.rkss.rpg.coc.rules

import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.traits.DiceResult

private class SkillRollResolver private () {
  def roll(
      rollable: SkillRollable,
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice
  )(implicit hundredSidedDice: HundredSidedDice): SkillRollResult = {
    val regular = rollable.value(difficulty)
    val hard = regular / 2
    val extreme = regular / 5

    val fumble = if (regular < 50) 96 else 100

    val rolled = rollDice(bonusDice, penaltyDice).value

    rolled match {
      case 1                                   => CriticalSuccess
      case diceResult if diceResult >= fumble  => Fumble
      case diceResult if diceResult <= extreme => ExtremeSuccess
      case diceResult if diceResult <= hard    => HardSuccess
      case diceResult if diceResult <= regular => RegularSuccess
      case _                                   => Failure
    }
  }

  private def rollDice(bonusDice: BonusDice, penaltyDice: PenaltyDice)(implicit
      hundredSidedDice: HundredSidedDice
  ): DiceResult = {
    val diff = bonusDice.value - penaltyDice.value

    val dice = 1 + Math.abs(diff)

    val rolled = (1 to dice).map(_ => hundredSidedDice.roll).sortBy(_.value)

    if (diff < 0) rolled.last else rolled.head
  }
}

private object SkillRollResolver {
  lazy val instance: SkillRollResolver = {
    new SkillRollResolver
  }
}
