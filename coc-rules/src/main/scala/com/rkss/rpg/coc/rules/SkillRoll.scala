package com.rkss.rpg.coc.rules

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.RollableEntity

final case class SkillRoll(
    val rollable: RollableEntity,
    val difficulty: SkillRollDifficultyLevel = RegularDifficulty,
    val bonusDice: BonusDice = BonusDice(0),
    val penaltyDice: PenaltyDice = PenaltyDice(0)
)(implicit private val hundredSidedDice: HundredSidedDice) {
  lazy val result: SkillRolled = roll

  private def roll: SkillRolled = SkillRollResolver.instance.roll(
    rollable,
    difficulty,
    bonusDice,
    penaltyDice
  )
}
