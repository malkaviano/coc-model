package com.rkss.rpg.coc.concepts.results

sealed trait SkillRollResult

sealed trait SkillRollSuccessResult extends SkillRollResult

case object SkillRollRegularSuccess extends SkillRollSuccessResult

case object SkillRollHardSuccess extends SkillRollSuccessResult

case object SkillRollExtremeSuccess extends SkillRollSuccessResult

case object SkillRollCriticalSuccess extends SkillRollSuccessResult

sealed trait SkillRollFailureResult extends SkillRollResult

case object SkillRollFumble extends SkillRollFailureResult

case object SkillRollFailure extends SkillRollFailureResult
