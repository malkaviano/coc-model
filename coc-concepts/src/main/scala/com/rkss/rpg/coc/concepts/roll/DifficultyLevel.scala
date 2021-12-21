package com.rkss.rpg.coc.concepts.roll

sealed trait DifficultyLevel

case object RegularDifficulty extends DifficultyLevel

case object HardDifficulty extends DifficultyLevel

case object ExtremeDifficulty extends DifficultyLevel