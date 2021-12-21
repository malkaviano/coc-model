package com.rkss.rpg.coc.concepts.roll

sealed trait SkillRollResult

case object FumbleResult extends SkillRollResult

case object FailureResult extends SkillRollResult

case object RegularSuccessResult extends SkillRollResult

case object HardSuccessResult extends SkillRollResult

case object ExtremeSuccessResult extends SkillRollResult

case object CriticalSuccessResult extends SkillRollResult
