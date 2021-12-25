package com.rkss.rpg.coc.rules

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.skill.roll.RegularDifficulty

trait SkillImprovement { self: Skill with SkillImprovable =>
  private var _improvedValue: Int = 0

  override def improvedValue: Int = _improvedValue

  private val _usedWithSuccess: Boolean = false

  override def usedWithSuccess: Boolean = _usedWithSuccess

  def improvementCheck(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): Unit = {
    if (usedWithSuccess) {
      val rolled = hundredSidedDice.roll

      val currentValue = value(RegularDifficulty)

      val result = rolled.value match {
        case x if x >= 95 || x > currentValue => Some(tenSidedDice.roll.value)
        case _                                => None
      }

      _improvedValue += result.getOrElse(0)

      // TODO: update usedWithSuccess to false
    }
  }
}
