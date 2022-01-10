package com.rkss.rpg.coc.foundations.skills

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.rules.behaviors._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.coc.concepts.skill.allocation.SkillWithPointsAllocation
import com.rkss.rpg.coc.concepts._

sealed trait Accounting
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

object Accounting {
  def create(occupation: Int = 0, personal: Int = 0): Accounting = {
    new Accounting {
      override val id: Identification = SkillAccounting

      override val baseValue: Int = 5

      override val occupationPoints: Int = occupation

      override val personalPoints: Int = personal
    }
  }
}
