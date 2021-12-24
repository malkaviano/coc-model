package com.rkss.testing.props

import com.rkss.rpg.coc.concepts.skill.roll._

final case class FakeRollableNonPushable(private val base: Int) extends SkillRollable {
  override def value(difficulty: SkillRollDifficultyLevel): Int = base
}
