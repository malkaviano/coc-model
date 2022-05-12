package com.rkss.rpg.coc.behaviors.testing.fakes

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.coc.concepts.roll._
import com.rkss.rpg.coc.behaviors.extractor._

class FakeSkill[A <: SkillName](
    override val name: A,
    val baseValue: Int,
    override val tags: Seq[SkillTag] = Seq.empty[SkillTag]
) extends Skill[A]
    with SkillRollCheckable[A]
    with SkillRollBehavior[A] {
  override def value(difficulty: SkillRollDifficultyLevel): Int =
    DifficultyValueExtractor.value(baseValue, difficulty)
}
