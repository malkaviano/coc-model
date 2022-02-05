package com.rkss.rpg.coc.behaviors.results

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
    val ImprovementChecked(rolled, improved) =
      ImprovementCheckExecutor.instance.improvementCheck(skill)

    val skillValue = skill.value()

    val sanityGainEligible = skillValue < 90 && skillValue + improved >= 90

    SkillImproved(
      skill.name,
      skillValue,
      improved,
      Some(rolled),
      sanityGainEligible
    )
  }
}
