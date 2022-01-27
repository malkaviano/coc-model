package com.rkss.rpg.coc.concepts.sanity

trait SanityRolledResult

case object SuccessResult extends SanityRolledResult

case object FailureResult extends SanityRolledResult

case object Fumble extends SanityRolledResult
