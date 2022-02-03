package com.rkss.rpg.coc.concepts.sanity

trait SanityRollResult

case object SuccessResult extends SanityRollResult

case object FailureResult extends SanityRollResult

case object Fumble extends SanityRollResult
