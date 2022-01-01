package com.rkss.rpg.coc.rules

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.helpers.traits.DiceResult
import com.rkss.rpg.coc.concepts.skill.improvement._

private final class SkillImprovementCheck private () {
  def improvementCheck(skill: Skill with SkillSuccessCheck)(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): SkillImprovementResult = {
    val none = SkillImprovementResult(skill, 0, Option.empty[DiceResult], false)
    skill.successCheck match {
      case true =>
        val roll = tenSidedDice.roll
        val skillValue = skill.value()

        hundredSidedDice.roll.value match {
          case x if x > skillValue || x > 95 =>
            SkillImprovementResult(
              skill,
              roll.value,
              Option(roll),
              skillValue < 90 && skillValue + roll.value >= 90
            )
          case _ => none
        }
      case _ => none
    }
  }
}

private object SkillImprovementCheck {
  lazy val instance: SkillImprovementCheck = {
    new SkillImprovementCheck
  }
}
