package com.rkss.rpg.coc.rules

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.helpers.dice.{HundredSidedDice, TenSidedDice}

private[coc] final case class SkillImprovement(
    val skill: Skill with SkillSuccessCheck
)(implicit
    hundredSidedDice: HundredSidedDice,
    tenSidedDice: TenSidedDice
) {
  lazy val result: SkillImprovementResult = {
    SkillImprovementCheck.instance.improvementCheck(skill)
  }
}
