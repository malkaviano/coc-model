package com.rkss.rpg.coc.concepts

sealed trait RollDifficulty

case object RegularDifficulty extends RollDifficulty

case object HardDifficulty extends RollDifficulty

case object ExtremeDifficulty extends RollDifficulty