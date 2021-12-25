package com.rkss.rpg.coc.rules

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.skill.roll.RegularDifficulty
import com.rkss.rpg.helpers.traits.DiceResult

trait SkillImprovement { self: Skill =>
  def improvementCheck(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): Option[DiceResult] = {
    val rolled = hundredSidedDice.roll

    val currentValue = value(RegularDifficulty)

    rolled.value match {
      case x if x > 95 || x > currentValue => Some(tenSidedDice.roll)
      case _                               => None
    }
  }
}
