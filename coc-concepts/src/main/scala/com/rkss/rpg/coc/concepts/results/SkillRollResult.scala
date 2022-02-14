package com.rkss.rpg.coc.concepts.results

sealed trait SkillRollResult {
  val value: Int
}

sealed trait SkillRollSuccessResult extends SkillRollResult

case object SkillRollRegularSuccess extends SkillRollSuccessResult {
  override val value: Int = 1
}

case object SkillRollHardSuccess extends SkillRollSuccessResult {
  override val value: Int = 2
}

case object SkillRollExtremeSuccess extends SkillRollSuccessResult {
  override val value: Int = 3
}

case object SkillRollCriticalSuccess extends SkillRollSuccessResult {
  override val value: Int = 4
}

sealed trait SkillRollFailureResult extends SkillRollResult

case object SkillRollFumble extends SkillRollFailureResult {
  override val value: Int = 0
}

case object SkillRollFailure extends SkillRollFailureResult {
  override val value: Int = 0
}
