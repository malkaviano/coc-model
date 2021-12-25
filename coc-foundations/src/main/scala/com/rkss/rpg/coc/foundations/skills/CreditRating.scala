package com.rkss.rpg.coc.foundations.skills

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill.Skill
import com.rkss.rpg.coc.rules._

trait CreditRating extends BasicSkill with SkillPushable {
  override lazy val name: String = "Credit Rating"

  override lazy val baseValue: Int = 0
}

object CreditRating {
  def create: Skill = {
    new CreditRating {
      override def roll(
          difficulty: SkillRollDifficultyLevel,
          bonusDice: BonusDice,
          penaltyDice: PenaltyDice
      ): SkillRollResult = ???
    }
  }
}
