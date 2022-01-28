package com.rkss.rpg.coc.rules.skill

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.helpers.dice.{HundredSidedDice, TenSidedDice}

private final case class SkillImprovement(
    val skill: Skill with SkillSuccessCheck
)(implicit
    hundredSidedDice: HundredSidedDice,
    tenSidedDice: TenSidedDice
) {
  lazy val result: SkillImproved = {
    SkillImprovementCheck.instance.improvementCheck(skill)
  }
}
