package com.rkss.rpg.coc.props.fakes

import com.rkss.rpg.coc.concepts.PrimaryCharacteristic
import com.rkss.rpg.coc.concepts.skill.roll._

final case class FakeCharacteristic(
    private val regular: Int,
    private val hard: Int,
    private val extreme: Int
) extends PrimaryCharacteristic {

  override def value(difficulty: SkillRollDifficultyLevel): Int = {
    difficulty match {
      case RegularDifficulty => regular
      case HardDifficulty    => hard
      case ExtremeDifficulty => extreme
    }
  }
}
