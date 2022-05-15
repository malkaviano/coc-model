package com.rkss.rpg.coc.fundamentals

import com.rkss.rpg.coc.concepts.roll._
import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.helpers.fixtures._
import com.rkss.rpg.coc.behaviors.extractor._

private[fundamentals] abstract class BaseRollable[A <: SkillRollNaming](
    name: A,
    initial: Int,
    minimum: Int = 0,
    maximum: Int = 100000
) extends SkillRollCheckable[A]
    with SkillRollBehavior[A] {
  private val internalState: BasicIntFixture[A] =
    BasicIntFixture(
      name,
      BasicIntOptions(initial = initial, minimum = minimum, maximum = maximum)
    )

  def onChange(callback: (BasicIntChangeEvent) => Unit): Unit = {
    internalState.addChangeListener(callback)
  }

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
