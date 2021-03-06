package com.rkss.rpg.coc.behaviors.roll

import com.rkss.rpg.coc.concepts.roll._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.behaviors.executors._
import com.rkss.rpg.coc.concepts.results._

private[coc] trait SkillRollBehavior[A <: SkillRollNaming] {
  self: SkillRollCheckable[A] =>
  protected var lastSkillRolled: Option[SkillRolled[A]] = None

  override def roll(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty,
      bonusDice: BonusDice = BonusDice(0),
      penaltyDice: PenaltyDice = PenaltyDice(0)
  )(implicit hundredSidedDice: HundredSidedDice): SkillRolled[A] = {
    lastSkillRolled = Option(
      SkillRollExecutor.instance.roll(
        this,
        difficulty,
        bonusDice,
        penaltyDice
      )(Right(hundredSidedDice))
    )

    lastSkillRolled.get
  }

  override def roll(
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice,
      diceRolled: SkillRollDiceResult
  ): SkillRolled[A] = {
    lastSkillRolled = Option(
      SkillRollExecutor.instance.roll(
        this,
        difficulty,
        bonusDice,
        penaltyDice
      )(Left(diceRolled))
    )

    lastSkillRolled.get
  }
}
