package com.rkss.rpg.coc.behaviors.skill.facts

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.coc.behaviors.executors._
import com.rkss.rpg.helpers.dice.{HundredSidedDice, TenSidedDice}

private[behaviors] final case class SkillImprovement[A <: SkillName](
    val skill: Skill[A] with SkillSuccessMark
)(implicit
    hundredSidedDice: HundredSidedDice,
    tenSidedDice: TenSidedDice
) {
  lazy val result: SkillImproved[A] = {
    ImprovementCheckExecutor.instance.improvementCheck(skill)
  }
}
