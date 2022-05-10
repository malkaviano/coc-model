package com.rkss.rpg.coc.behaviors.testing.fakes

import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill._

final case class FakeSkillImprovable[A <: ImprovableSkillName](
    override val name: A,
    override val baseValue: Int,
    override val occupationPoints: Int = 0,
    override val personalPoints: Int = 0,
    override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
) extends FakeSkillWithAllocation(
      name,
      baseValue,
      occupationPoints,
      personalPoints,
      tags
    )
    with SkillSuccessMark
    with SkillSuccessMarkable
    with SkillSuccessfullyUsedBehavior
    with SkillWithImprovement
    with SkillImprovable[A]
    with SkillImprovementBehavior[A]
