package com.rkss.rpg.coc.foundations.skills

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill.Skill
import com.rkss.rpg.coc.rules.behaviors._

trait CreditRating
    extends Skill
    with SkillRollBehavior
    with SkillPushable
    with PushableSkillRollBehavior

object CreditRating {
  val name = "Credit Rating"

  def create: CreditRating = {
    new CreditRating {
      override val name: String = CreditRating.name

      override val baseValue: Int = 0
    }
  }
}
