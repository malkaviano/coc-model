package com.rkss.rpg.coc.foundations.characteristics

import com.rkss.rpg.coc.concepts.PrimaryCharacteristic
import com.rkss.rpg.coc.concepts.skill.roll._

class GenericCharacteristic private[characteristics] (
    val name: String,
    protected val baseValue: Int
) extends PrimaryCharacteristic {

  override def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    difficulty match {
      case RegularDifficulty => baseValue
      case HardDifficulty    => baseValue / 2
      case ExtremeDifficulty => baseValue / 5
    }
  }
}
