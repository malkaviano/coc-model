package com.rkss.rpg.coc.foundations.skills

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.rules._
import com.rkss.rpg.coc.rules.behaviors._

trait FirstAid
    extends Skill
    with SkillPushable
    with SkillImprovable
    with SkillImprovement
    with SkillRollBehavior
    with ImprovableSkillBehavior
    with PushableSkillRollBehavior

object FirstAid {
  val name = "First Aid"

  def create: FirstAid = {
    new FirstAid {
      override val name: String = FirstAid.name

      override val baseValue: Int = 30
    }
  }
}
