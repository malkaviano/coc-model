package com.rkss.rpg.coc.foundations.specs

import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.concepts.skill.roll._

final case class PushSkillRollSpec(
    val entity: SkillPushable with EntityWithDifficultyValue,
    val difficulty: Option[SkillRollDifficultyLevel],
    val bonusDice: Option[BonusDice],
    val penaltyDice: Option[PenaltyDice],
    val rolled: Seq[Int],
    val rolledResult: SkillRolledResult,
    val rollDiceResult: SkillRollDiceResult,
    val expected: Option[SkillRolled]
)