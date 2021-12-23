package com.rkss.testing.props

import com.rkss.rpg.coc.concepts.roll.Rollable
import com.rkss.rpg.coc.concepts.roll.SkillRollDifficultyLevel

final case class FakeRollableNonPushable(private val base: Int) extends Rollable {
  override def value(difficulty: SkillRollDifficultyLevel): Int = base
}
