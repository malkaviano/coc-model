package com.rkss.rpg.coc.concepts.results

sealed trait SanityRollResult

case object SanityRollSuccessResult extends SanityRollResult

case object SanityRollFailureResult extends SanityRollResult

case object SanityRollFumble extends SanityRollResult
