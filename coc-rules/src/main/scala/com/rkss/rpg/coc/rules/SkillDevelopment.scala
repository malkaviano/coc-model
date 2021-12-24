package com.rkss.rpg.coc.rules

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.helpers.dice._

trait SkillDevelopment { this: Skill with SkillUsedCheck =>
  def develop(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): SkillDevelopmentResult = {
    if (succeeded) {
      val rolled = hundredSidedDice.roll

      val currentValue = value()

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
