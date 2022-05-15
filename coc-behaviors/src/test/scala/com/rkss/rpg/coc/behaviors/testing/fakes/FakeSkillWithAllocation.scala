package com.rkss.rpg.coc.behaviors.testing.fakes

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.roll._
import com.rkss.rpg.coc.behaviors.extractor._

class FakeSkillWithAllocation[A <: AllocationSkillName](
    override val name: A,
    override val baseValue: Int,
    val occupationPoints: Int = 0,
    val personalPoints: Int = 0
) extends FakeSkill[A](name, baseValue) {
  override def value(difficulty: SkillRollDifficultyLevel): Int =
    DifficultyValueExtractor.value(
      baseValue + occupationPoints + personalPoints,
      difficulty
    )
}
