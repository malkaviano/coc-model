package com.rkss.rpg.coc.helpers.converters

import com.rkss.rpg.coc.concepts.roll._

object DifficultyConverter {
  def fromSkills(
      opposingSkills: SkillRollCheckable[SkillRollNaming]*
  ): SkillRollDifficultyLevel = {
    fromValue(opposingSkills.maxBy(_.value()).value())
  }

  def fromValue(opposingValue: Int): SkillRollDifficultyLevel = {
    opposingValue match {
      case x if x < 50 => RegularDifficulty
      case x if x < 90 => HardDifficulty
      case _           => ExtremeDifficulty
    }
  }
}
