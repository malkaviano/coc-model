package com.rkss.rpg.coc.foundations.skills

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill.Skill
import com.rkss.rpg.coc.rules.behaviors._
import com.rkss.rpg.coc.concepts.skill.allocation.SkillWithPointsAllocation
import com.rkss.rpg.coc.concepts._

sealed trait CreditRating
    extends Skill
    with SkillWithPointsAllocation
    with SkillPushable
    with SkillRollBehavior
    with WithDifficultyValueBehavior
    with PushableSkillRollBehavior
    with WithModificationValueBehavior

object CreditRating {
  def create(occupation: Int = 0, personal: Int = 0): CreditRating = {
    new CreditRating {
      override val id: Identification = SkillCreditRating

      override val baseValue: Int = 0

      override val occupationPoints: Int = occupation

      override val personalPoints: Int = personal
    }
  }
}
