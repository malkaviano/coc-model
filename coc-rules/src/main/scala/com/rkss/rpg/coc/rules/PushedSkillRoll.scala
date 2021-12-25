package com.rkss.rpg.coc.rules

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice.HundredSidedDice

final case class PushedSkillRoll(
    private val failedSkillRoll: SkillRoll,
    private val pushedDifficulty: Option[SkillRollDifficultyLevel] = None,
    private val pushedBonusDice: Option[BonusDice] = None,
    private val pushedPenaltyDice: Option[PenaltyDice] = None
)(implicit private val hundredSidedDice: HundredSidedDice) {
  lazy val result: Option[SkillRolled] = {
    canPush match {
      case true => {
        Some(roll)
      }
      case _ => None
    }
  }

  private def canPush: Boolean = {
    failedSkillRoll.rollable
      .isInstanceOf[SkillPushable] && failedSkillRoll.result.rollResult == Failure
  }

  private def roll: SkillRolled = SkillRollResolver.instance.roll(
    failedSkillRoll.rollable,
    pushedDifficulty.getOrElse(failedSkillRoll.difficulty),
    pushedBonusDice.getOrElse(failedSkillRoll.bonusDice),
    pushedPenaltyDice.getOrElse(failedSkillRoll.penaltyDice)
  )
}
