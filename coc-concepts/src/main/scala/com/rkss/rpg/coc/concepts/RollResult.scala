package com.rkss.rpg.coc.concepts

sealed trait RollResult

case object SuccessRoll extends RollResult

case object FailureRoll extends RollResult