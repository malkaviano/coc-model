package com.rkss.rpg.coc.foundations.skills

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill.Skill
import com.rkss.rpg.coc.rules.behaviors._

sealed trait CreditRating
    extends Skill
    with SkillWithDifficultyValueBehavior
    with SkillRollBehavior
    with SkillPushable
    with PushableSkillRollBehavior

object CreditRating {
  val name = "Credit Rating"

  def create(occupation: Int = 0, personal: Int = 0): CreditRating = {
    new CreditRating {
      override val name: String = CreditRating.name

      override val baseValue: Int = 0

      override val occupationPoints: Int = occupation

      override val personalPoints: Int = personal
    }
  }
}
