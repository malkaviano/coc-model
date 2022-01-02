package com.rkss.rpg.coc.rules

import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.traits.DiceResult
import com.rkss.rpg.coc.concepts.EntityWithDifficultyValue
import com.rkss.rpg.coc.concepts.skill.Skill

private class SkillRollResolver private () {
  def roll(
      rollable: EntityWithDifficultyValue,
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice
  )(implicit hundredSidedDice: HundredSidedDice): SkillRolled = {
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

    SkillRolled(rollable, difficulty, bonusDice, penaltyDice, result, rolled)
  }

  def rollOpposedBy(
      skill: Skill,
      opposedBy: EntityWithDifficultyValue,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice
  )(implicit hundredSidedDice: HundredSidedDice): SkillRolled = {
    val difficulty = opposedBy.value() match {
      case x if x >= 90 => ExtremeDifficulty
      case x if x >= 50 => HardDifficulty
      case _            => RegularDifficulty
    }

    val result = roll(skill, difficulty, bonusDice, penaltyDice)

    result.copy(opposedBy = Option(opposedBy))
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
