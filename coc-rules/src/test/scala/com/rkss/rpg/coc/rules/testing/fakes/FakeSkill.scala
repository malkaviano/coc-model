package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.rules.behaviors._
import com.rkss.rpg.coc.concepts.skill.allocation.SkillWithPointsAllocation

class FakeSkill(
    override val baseValue: Int,
    override val occupationPoints: Int = 0,
    override val personalPoints: Int = 0,
    override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
) extends Skill
    with WithDifficultyValueBehavior
    with SkillRollBehavior
    with SkillWithPointsAllocation
    with WithModificationValueBehavior
