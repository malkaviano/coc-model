package com.rkss.rpg.coc.behaviors.skill

import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.behaviors.skill.facts._

private[coc] trait SkillRollBehavior[A <: NameTag] {
  self: EntityWithDifficultyValue with SkillRollable[A] with EntityWithNameTag[A] =>
  protected var lastSkillRolled: Option[SkillRolled[A]] = None

  override def roll(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty,
      bonusDice: BonusDice = BonusDice(0),
      penaltyDice: PenaltyDice = PenaltyDice(0)
  )(implicit hundredSidedDice: HundredSidedDice): SkillRolled[A] = {
    lastSkillRolled = Option(
      SkillRoll(this, difficulty, bonusDice, penaltyDice).result
    )

    lastSkillRolled.get
  }
}
