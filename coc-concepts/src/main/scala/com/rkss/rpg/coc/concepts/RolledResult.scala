package com.rkss.rpg.coc.concepts

private[coc] sealed trait RolledResult

case object SuccessRoll extends RolledResult

case object FailureRoll extends RolledResult