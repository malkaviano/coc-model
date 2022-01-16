package com.rkss.rpg.coc.foundations.skills

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.rules.behaviors._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.coc.concepts.skill.allocation.SkillWithPointsAllocation

trait FirstAid
    extends Skill
    with SkillWithPointsAllocation
    with SkillPushable
    with SkillSuccessCheck
    with SkillSuccessCheckable
    with SkillWithImprovedValue
    with SkillImprovable
    with SkillRollBehavior
    with SkillSuccessfullyUsedBehavior
    with PushableSkillRollBehavior
    with SkillImprovementBehavior
    with WithDifficultyValueBehavior
    with WithModificationValueBehavior

object FirstAid {
  def create(occupationPoints: Int = 0, personalPoints: Int = 0): FirstAid = {
    new SimpleSkill(30, occupationPoints, personalPoints)
      with FirstAid
  }
}
