package com.rkss.rpg.coc.rules

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.skill._

private final class SkillImprovementCheck private () {
  def improvementCheck(skill: Skill with SkillSuccessCheck)(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): SkillImprovementResult = {
    ???
  }
}

private object SkillImprovementCheck {
  lazy val instance: SkillImprovementCheck = {
    new SkillImprovementCheck
  }
}