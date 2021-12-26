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
    with ImprovableSkillBehavior {
  override lazy val name: String = "First Aid"

  override lazy val baseValue: Int = 30
}

object FirstAid {
  def create: Skill = {
    new FirstAid {}
  }
}
