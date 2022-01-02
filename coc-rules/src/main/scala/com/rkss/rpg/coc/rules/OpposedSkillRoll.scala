package com.rkss.rpg.coc.rules

import com.rkss.rpg.coc.concepts.skill.Skill
import com.rkss.rpg.coc.concepts.EntityWithDifficultyValue
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice.HundredSidedDice

private final case class OpposedSkillRoll(
    val skill: Skill,
    val opposedBy: EntityWithDifficultyValue,
    val bonusDice: BonusDice = BonusDice(0),
    val penaltyDice: PenaltyDice = PenaltyDice(0)
)(implicit private val hundredSidedDice: HundredSidedDice) {
  lazy val result: SkillRolled = roll

  private def roll: SkillRolled = SkillRollResolver.instance.rollOpposedBy(
    skill,
    opposedBy,
    bonusDice,
    penaltyDice
  )
}
