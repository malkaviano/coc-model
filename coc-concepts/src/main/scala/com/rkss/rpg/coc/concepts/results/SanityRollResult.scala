package com.rkss.rpg.coc.concepts.results

trait SanityRollResult

case object SanityRollSuccessResult extends SanityRollResult

case object SanityRollFailureResult extends SanityRollResult

case object SanityRollFumble extends SanityRollResult
