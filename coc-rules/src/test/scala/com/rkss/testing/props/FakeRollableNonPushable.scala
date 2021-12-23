package com.rkss.testing.props

import com.rkss.rpg.coc.concepts.skillroll.Rollable
import com.rkss.rpg.coc.concepts.skillroll.SkillRollDifficultyLevel

final case class FakeRollableNonPushable(private val base: Int) extends Rollable {
  override def value(difficulty: SkillRollDifficultyLevel): Int = base
}
