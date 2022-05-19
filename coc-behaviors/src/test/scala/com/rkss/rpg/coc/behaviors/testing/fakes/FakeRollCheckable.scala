package com.rkss.rpg.coc.behaviors.testing.fakes

import com.rkss.rpg.coc.behaviors.roll._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.concepts.roll._
import com.rkss.rpg.coc.behaviors.extractor._

final case class FakeCharacteristic[A <: CharacteristicName](
    override val name: A,
    val baseValue: Int,
    override val id: String = "id"
) extends SkillRollCheckable[A]
    with SkillRollBehavior[A] {
  override def value(difficulty: SkillRollDifficultyLevel): Int =
    DifficultyValueExtractor.value(baseValue, difficulty)
}
