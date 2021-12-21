package com.rkss.rpg.coc.concepts.roll

sealed trait SkillRollResult

sealed trait SuccessResult extends SkillRollResult

case object RegularSuccess extends SuccessResult

case object HardSuccess extends SuccessResult

case object ExtremeSuccess extends SuccessResult

case object CriticalSuccess extends SuccessResult

sealed trait FailureResult extends SkillRollResult

case object Fumble extends FailureResult

case object Failure extends FailureResult
