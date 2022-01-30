package com.rkss.rpg.coc.rules.skill

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.helpers.dice.{HundredSidedDice, TenSidedDice}

private final case class SkillImprovement[A <: SkillName](
    val skill: Skill[A] with SkillSuccessMark
)(implicit
    hundredSidedDice: HundredSidedDice,
    tenSidedDice: TenSidedDice
) {
  lazy val result: SkillImproved[A] = {
    SkillImprovementCheck.instance.improvementCheck(skill)
  }
}
