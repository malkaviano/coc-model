package com.rkss.rpg.coc.behaviors.skill

import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.coc.behaviors.skill.facts._

private[coc] trait PushableSkillRollBehavior[A <: NameTag] extends SkillRollBehavior[A] {
  self: EntityWithDifficultyValue
    with SkillRollable[A]
    with SkillPushable[A]
    with EntityWithNameTag[A] =>

  override def pushRoll(
      difficulty: Option[SkillRollDifficultyLevel] = None,
      bonusDice: Option[BonusDice] = None,
      penaltyDice: Option[PenaltyDice] = None
  )(implicit hundredSidedDice: HundredSidedDice): Option[SkillRolled[A]] = {
    lastSkillRolled match {
      case skillRolled: Option[SkillRolled[A]] if skillRolled.isDefined =>
        if (skillRolled.get.pushed) {
          Option.empty[SkillRolled[A]]
        } else {
          PushSkillRoll[A](
            this,
            skillRolled.get,
            difficulty,
            bonusDice,
            penaltyDice
          ).result match {
            case Some(value) => {
              lastSkillRolled = Option(
                value.copy(pushed = true)
              )

              lastSkillRolled
            }
            case None => Option.empty[SkillRolled[A]]
          }
        }
      case None =>
        Option.empty[SkillRolled[A]]
      case Some(_) => ???
    }
  }
}
