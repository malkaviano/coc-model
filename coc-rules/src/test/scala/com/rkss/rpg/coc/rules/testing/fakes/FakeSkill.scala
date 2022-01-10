package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.rules.behaviors._
import com.rkss.rpg.coc.concepts.skill.allocation.SkillWithPointsAllocation
import com.rkss.rpg.coc.concepts.Identification
import com.rkss.rpg.coc.concepts.SkillAccounting

class FakeSkill(
    override val baseValue: Int,
    override val occupationPoints: Int = 0,
    override val personalPoints: Int = 0
) extends Skill
    with WithDifficultyValueBehavior
    with SkillRollBehavior
    with SkillWithPointsAllocation
    with WithModificationValueBehavior {
  override val id: Identification = SkillAccounting
}
