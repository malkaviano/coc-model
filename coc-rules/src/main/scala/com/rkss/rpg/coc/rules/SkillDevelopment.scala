package com.rkss.rpg.coc.rules

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice._

trait SkillDevelopment extends SkillUsedCheck { this: Skill =>
  private var successfullyUsed: Boolean = false

  private var improvedValue: Int = 0

  override def succeeded: Boolean = successfullyUsed

  def improved: Int = improvedValue

  def checkSuccess(skillRollResult: SkillRollResult): Unit = {
    successfullyUsed ||= skillRollResult.isInstanceOf[SuccessResult]
  }

  def develop(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): Unit = {
    if (successfullyUsed) {
      successfullyUsed = false

      val rolled = hundredSidedDice.roll

      val currentValue = value()

      val improveRolledValue = rolled.value match {
        case x if x >= 95 || x > currentValue => tenSidedDice.roll.value
        case _                                => 0
      }

      improvedValue += improveRolledValue
    }
  }
}
