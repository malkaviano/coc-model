package com.rkss.rpg.coc.concepts.results

sealed trait RollResult

case object SuccessRoll extends RollResult

case object FailureRoll extends RollResult