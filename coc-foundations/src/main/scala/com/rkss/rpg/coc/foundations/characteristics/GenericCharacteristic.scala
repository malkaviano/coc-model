package com.rkss.rpg.coc.foundations.characteristics

import com.rkss.rpg.coc.concepts.characteristics.PrimaryCharacteristic
import com.rkss.rpg.coc.concepts.roll._

class GenericCharacteristic(val name: String, protected val base: Int)
    extends PrimaryCharacteristic {

  override def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    difficulty match {
      case RegularDifficulty => this.base
      case HardDifficulty => this.base / 2
      case ExtremeDifficulty => this.base / 5
    }
  }
}
