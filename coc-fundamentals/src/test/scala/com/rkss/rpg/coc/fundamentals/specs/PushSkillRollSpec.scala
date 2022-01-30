package com.rkss.rpg.coc.fundamentals.specs

import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.concepts.skill.roll._

final case class PushSkillRollSpec[A <: NameTag](
    val entity: SkillPushable[A] with EntityWithDifficultyValue,
    val difficulty: Option[SkillRollDifficultyLevel],
    val bonusDice: Option[BonusDice],
    val penaltyDice: Option[PenaltyDice],
    val rolled: Seq[Int],
    val rolledResult: SkillRollResult,
    val rollDiceResult: SkillRollDiceResult,
    val expected: Option[SkillRolled[A]]
)