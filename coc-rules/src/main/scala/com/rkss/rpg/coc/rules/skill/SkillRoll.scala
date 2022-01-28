package com.rkss.rpg.coc.rules.skill

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts._

private final case class SkillRoll(
    private val rollable: EntityWithDifficultyValue with EntityWithNameTag,
    private val difficulty: SkillRollDifficultyLevel = RegularDifficulty,
    private val bonusDice: BonusDice = BonusDice(0),
    private val penaltyDice: PenaltyDice = PenaltyDice(0)
)(implicit private val hundredSidedDice: HundredSidedDice) {
  lazy val result: SkillRolled = roll

  private def roll: SkillRolled = SkillRollResolver.instance.roll(
    rollable,
    difficulty,
    bonusDice,
    penaltyDice
  )
}
