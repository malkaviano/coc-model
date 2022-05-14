package com.rkss.rpg.coc.behaviors.testing.fakes

import com.rkss.rpg.coc.concepts.skill.allocation._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.roll._
import com.rkss.rpg.coc.behaviors.extractor._

class FakeSkillWithAllocation[A <: AllocationSkillName](
    override val name: A,
    override val baseValue: Int,
    override val occupationPoints: Int = 0,
    override val personalPoints: Int = 0,
    override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
) extends FakeSkill(name, baseValue, tags)
    with SkillWithPointsAllocation {
  override def value(difficulty: SkillRollDifficultyLevel): Int =
    DifficultyValueExtractor.value(
      baseValue + occupationPoints + personalPoints,
      difficulty
    )
}
