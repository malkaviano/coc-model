package com.rkss.rpg.coc.rules

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.skillroll._

final case class SkillRoll(
    val rollable: Rollable,
    val difficulty: SkillRollDifficultyLevel = RegularDifficulty,
    val bonusDice: BonusDice = BonusDice(0),
    val penaltyDice: PenaltyDice = PenaltyDice(0)
)(implicit private val hundredSidedDice: HundredSidedDice) {
  private var pushed = false

  lazy val result: SkillRollResult = roll

  lazy val push: Option[SkillRollResult] = {
    canPush match {
      case true => {
        pushed = true

        Some(roll)
      }
      case _ => None
    }
  }

  private def roll: SkillRollResult = SkillRollResolver.instance.roll(
    rollable,
    difficulty,
    bonusDice,
    penaltyDice
  )

  private def canPush: Boolean = {
    !pushed && rollable.isInstanceOf[Pushable] && result == Failure
  }
}
