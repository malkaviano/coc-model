package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.rules.behaviors.SkillRollBehavior
import com.rkss.rpg.coc.rules.behaviors.SkillWithDifficultyValueBehavior

class FakeSkill(
    override val name: String,
    override val baseValue: Int,
    override val occupationPoints: Int = 0,
    override val personalPoints: Int = 0
) extends Skill
    with SkillWithDifficultyValueBehavior
    with SkillRollBehavior
