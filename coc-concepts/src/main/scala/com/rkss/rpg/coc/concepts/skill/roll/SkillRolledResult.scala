package com.rkss.rpg.coc.concepts.skill.roll

sealed trait SkillRolledResult

sealed trait SuccessResult extends SkillRolledResult

case object RegularSuccess extends SuccessResult

case object HardSuccess extends SuccessResult

case object ExtremeSuccess extends SuccessResult

case object CriticalSuccess extends SuccessResult

sealed trait FailureResult extends SkillRolledResult

case object Fumble extends FailureResult

case object Failure extends FailureResult
