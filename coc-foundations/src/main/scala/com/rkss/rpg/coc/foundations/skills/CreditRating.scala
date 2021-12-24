package com.rkss.rpg.coc.foundations.skills

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill.Skill

trait CreditRating extends Skill with SkillPushable {
  override lazy val name: String = "Credit Rating"

  override lazy val baseValue: Int = 0

  override def value(difficulty: SkillRollDifficultyLevel): Int = ???
}

object CreditRating {
  def create: Skill = {
    new CreditRating {}
  }
}
