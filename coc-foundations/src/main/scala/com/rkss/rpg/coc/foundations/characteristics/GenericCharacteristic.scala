package com.rkss.rpg.coc.foundations.characteristics

import com.rkss.rpg.coc.concepts.PrimaryCharacteristic
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.rules.SkillRollValue

class GenericCharacteristic private[characteristics] (
    val name: String,
    protected val baseValue: Int
) extends PrimaryCharacteristic {

  override def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    SkillRollValue(baseValue).value(difficulty)
  }

  override def roll(
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice
  ): SkillRollResult = {
    ???
  }
}
