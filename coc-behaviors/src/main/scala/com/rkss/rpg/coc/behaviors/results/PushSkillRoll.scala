package com.rkss.rpg.coc.behaviors.results

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts.commons._
import com.rkss.rpg.coc.behaviors.executors._
import com.rkss.rpg.coc.concepts.results._

private[behaviors] final case class PushSkillRoll[A <: Naming](
    private val entity: EntityWithDifficultyValue with EntityWithNameTag[A],
    private val skillRolled: SkillRolled[A],
    private val pushedDifficulty: Option[SkillRollDifficultyLevel] = None,
    private val pushedBonusDice: Option[BonusDice] = None,
    private val pushedPenaltyDice: Option[PenaltyDice] = None
)(implicit private val hundredSidedDice: HundredSidedDice) {
  lazy val result: Option[SkillRolled[A]] = {
    canPush match {
      case true => {
        Some(roll)
      }
      case _ => None
    }
  }

  private def canPush: Boolean = {
    entity.isInstanceOf[SkillPushable[_]] && skillRolled.result == SkillRollFailure
  }

  private def roll: SkillRolled[A] = SkillRollExecutor.instance.roll(
    entity,
    pushedDifficulty.getOrElse(skillRolled.difficulty),
    pushedBonusDice.getOrElse(skillRolled.bonusDice),
    pushedPenaltyDice.getOrElse(skillRolled.penaltyDice)
  )(Right(hundredSidedDice))
}
