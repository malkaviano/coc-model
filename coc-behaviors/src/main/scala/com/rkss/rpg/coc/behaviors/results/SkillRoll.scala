package com.rkss.rpg.coc.behaviors.results

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.concepts.commons._
import com.rkss.rpg.coc.behaviors.executors._

private[behaviors] final case class SkillRoll[A <: Naming](
    private val rollable: EntityWithDifficultyValue with EntityWithNameTag[A],
    private val difficulty: SkillRollDifficultyLevel = RegularDifficulty,
    private val bonusDice: BonusDice = BonusDice(0),
    private val penaltyDice: PenaltyDice = PenaltyDice(0)
)(implicit private val hundredSidedDice: HundredSidedDice) {
  lazy val result: SkillRolled[A] = roll

  private def roll: SkillRolled[A] = RollExecutor.instance.roll(
    rollable,
    difficulty,
    bonusDice,
    penaltyDice
  )
}
