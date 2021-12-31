package com.rkss.rpg.coc.concepts.skill.roll

private[coc] sealed trait SkillRollDifficultyLevel

case object RegularDifficulty extends SkillRollDifficultyLevel

case object HardDifficulty extends SkillRollDifficultyLevel

case object ExtremeDifficulty extends SkillRollDifficultyLevel
