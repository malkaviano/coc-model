package com.rkss.rpg.coc.foundations.skills

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.rules.behaviors._

sealed trait FirstAid
    extends Skill
    with SkillWithDifficultyValueBehavior
    with SkillPushable
    with SkillRollBehavior
    with PushableSkillRollBehavior
    with SkillSuccessCheck
    with SkillWithImprovedValue

object FirstAid {
  val name = "First Aid"

  def create(occupation: Int = 0, personal: Int = 0): FirstAid = {
    new FirstAid {
      override val name: String = FirstAid.name

      override val baseValue: Int = 30

      override val occupationPoints: Int = occupation

      override val personalPoints: Int = personal

      override def improvedValue: Int = 0

      override def successCheck: Boolean = false
    }
  }
}
