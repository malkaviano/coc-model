package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.rules.SkillRollValue
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.rules.SkillRoll

trait SkillRollBehavior { self: RollableEntity with SkillRollable =>
  protected var lastSkillRolled: Option[SkillRolled] = None

  override def value(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty
  ): Int = {
    SkillRollValue(baseValue).value(difficulty)
  }

  override def roll(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty,
      bonusDice: BonusDice = BonusDice(0),
      penaltyDice: PenaltyDice = PenaltyDice(0)
  )(implicit hundredSidedDice: HundredSidedDice): SkillRolled = {
    val result = SkillRoll(this, difficulty, bonusDice, penaltyDice).result

    lastSkillRolled = Option(result)

    result
  }
}
