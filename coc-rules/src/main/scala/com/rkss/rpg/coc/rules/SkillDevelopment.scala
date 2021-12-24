package com.rkss.rpg.coc.rules

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.skill.roll.RegularDifficulty

trait SkillDevelopment { this: Skill with SkillUsedCheck =>
  def improvedValue: Int

  def develop(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): SkillDevelopmentResult = {
    if (succeeded) {
      val rolled = hundredSidedDice.roll

      val currentValue = value(RegularDifficulty)

      val result = rolled.value match {
        case x if x >= 95 || x > currentValue => Some(tenSidedDice.roll.value)
        case _                                => None
      }

      SkillDevelopmentResult(result)
    } else {
      SkillDevelopmentResult(None)
    }
  }
}
