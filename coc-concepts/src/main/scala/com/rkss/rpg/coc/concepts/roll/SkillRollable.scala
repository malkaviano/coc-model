package com.rkss.rpg.coc.concepts.roll

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.internal._
import com.rkss.rpg.helpers.traits._
import com.rkss.rpg.coc.concepts.results._

trait SkillRollable[+A <: GlobalNameTag] { self: WithDifficultyValue =>
  def roll(
      difficulty: SkillRollDifficultyLevel = RegularDifficulty,
      bonusDice: BonusDice = BonusDice(0),
      penaltyDice: PenaltyDice = PenaltyDice(0)
  )(implicit hundredSidedDice: HundredSidedDice): SkillRolled[A]

  def roll(
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice,
      diceRolled: SkillRollDiceResult
  ): SkillRolled[A]
}
