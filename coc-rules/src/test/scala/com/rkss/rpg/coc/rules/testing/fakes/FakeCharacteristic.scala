package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.concepts.PrimaryCharacteristic
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice.HundredSidedDice

final case class FakeCharacteristic(
    private val regular: Int,
    private val hard: Int,
    private val extreme: Int
) extends PrimaryCharacteristic {
  override val name = "FakeCharacteristic"

  override def baseValue: Int = regular

  override def value(difficulty: SkillRollDifficultyLevel): Int = {
    difficulty match {
      case RegularDifficulty => regular
      case HardDifficulty    => hard
      case ExtremeDifficulty => extreme
    }
  }

  override def roll(
      difficulty: SkillRollDifficultyLevel,
      bonusDice: BonusDice,
      penaltyDice: PenaltyDice
  )(implicit hundredSidedDice: HundredSidedDice): SkillRolled = ???

  def pushRoll(
      difficulty: Option[SkillRollDifficultyLevel],
      bonusDice: Option[BonusDice],
      penaltyDice: Option[PenaltyDice]
  )(implicit hundredSidedDice: HundredSidedDice): Option[SkillRolled] = ???
}