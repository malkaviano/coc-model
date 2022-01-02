package com.rkss.rpg.coc.foundations.skills

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.rules.behaviors._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.coc.concepts.skill.allocation.SkillWithPointsAllocation

sealed trait Accounting
    extends Skill
    with SkillWithPointsAllocation
    with SkillPushable
    with SkillRollBehavior
    with PushableSkillRollBehavior
    with SkillSuccessCheck
    with SkillSuccessCheckable
    with SkillSuccessfullyUsedBehavior
    with SkillWithImprovedValue
    with SkillImprovable
    with SkillImprovementBehavior
    with WithDifficultyValueBehavior
    with SkillRollOpposable
    with OpposedSkillRollBehavior

object Accounting {
  val name = "Accounting"

  def create(occupation: Int = 0, personal: Int = 0): Accounting = {
    new Accounting {
      override val name: String = Accounting.name

      override val baseValue: Int = 5

      override val occupationPoints: Int = occupation

      override val personalPoints: Int = personal
    }
  }
}
