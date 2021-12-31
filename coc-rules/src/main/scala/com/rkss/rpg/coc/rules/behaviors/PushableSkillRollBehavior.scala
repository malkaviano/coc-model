package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.rules._

trait PushableSkillRollBehavior extends SkillRollBehavior {
  self: EntityWithDifficultyValue with SkillRollable with SkillPushable =>

  override def pushRoll(
      difficulty: Option[SkillRollDifficultyLevel] = None,
      bonusDice: Option[BonusDice] = None,
      penaltyDice: Option[PenaltyDice] = None
  )(implicit hundredSidedDice: HundredSidedDice): Option[SkillRolled] = {
    lastSkillRolled match {
      case Some(skillRolled) =>
        if (skillRolled.pushed) {
          Option.empty[SkillRolled]
        } else {
          PushedSkillRoll(skillRolled).result match {
            case Some(value) => {
              lastSkillRolled = Option(value.copy(pushed = true))

              lastSkillRolled
            }
            case None => Option.empty[SkillRolled]
          }
        }
      case None =>
        Option.empty[SkillRolled]
    }
  }
}
