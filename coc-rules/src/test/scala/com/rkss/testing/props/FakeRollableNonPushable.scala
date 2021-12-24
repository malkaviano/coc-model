package com.rkss.testing.props

import com.rkss.rpg.coc.concepts.skillroll.SkillRollable
import com.rkss.rpg.coc.concepts.skillroll.SkillRollDifficultyLevel

final case class FakeRollableNonPushable(private val base: Int) extends SkillRollable {
  override def value(difficulty: SkillRollDifficultyLevel): Int = base
}
