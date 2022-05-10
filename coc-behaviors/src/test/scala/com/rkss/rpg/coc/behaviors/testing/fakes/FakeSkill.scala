package com.rkss.rpg.coc.behaviors.testing.fakes

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.coc.behaviors._
import com.rkss.rpg.coc.concepts.internal._

class FakeSkill[A <: SkillName](
    override val name: A,
    override val baseValue: Int,
    override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
) extends Skill[A]
    with WithDifficultyValueBehavior
    with SkillRollBehavior[A]
    with WithModifiableValue[A]
    with WithValueModificationBehavior[A]
