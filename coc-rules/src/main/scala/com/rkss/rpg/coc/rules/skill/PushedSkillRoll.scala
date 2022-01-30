package com.rkss.rpg.coc.rules.skill

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts._

private final case class PushedSkillRoll(
    private val entity: EntityWithDifficultyValue with EntityWithNameTag,
    private val skillRolled: SkillRolled,
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
    entity.isInstanceOf[SkillPushable] && skillRolled.result == Failure
  }

  private def roll: SkillRolled = SkillRollResolver.instance.roll(
    entity,
    pushedDifficulty.getOrElse(skillRolled.difficulty),
    pushedBonusDice.getOrElse(skillRolled.bonusDice),
    pushedPenaltyDice.getOrElse(skillRolled.penaltyDice)
  )
}
