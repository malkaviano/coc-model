package com.rkss.rpg.coc.fundamentals

import com.rkss.rpg.coc.concepts.roll._
import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.helpers.fixtures._
import com.rkss.rpg.coc.behaviors.extractor._

abstract class BaseRollable[A <: SkillRollNaming](
    override val name: A,
    private val baseValue: Int,
    private val minimum: Int = 0,
    private val maximum: Int = 100000
) extends SkillRollCheckable[A]
    with SkillRollBehavior[A] {
  private val internalState: BasicIntFixture[A] =
    BasicIntFixture(
      name,
      BasicIntOptions(initial = baseValue, minimum = minimum, maximum = maximum)
    )

  override def value(difficulty: SkillRollDifficultyLevel): Int = {
    DifficultyValueExtractor.value(
      internalState.value,
      difficulty
    )
  }

  def increase(increment: BasicIntValue[A]): Unit = {
    internalState.plus(increment)
  }

  def decrease(decrement: BasicIntValue[A]): Unit = {
    internalState.minus(decrement)
  }
}
