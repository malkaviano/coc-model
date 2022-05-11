package com.rkss.rpg.coc.behaviors.results

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.coc.behaviors.executors._
import com.rkss.rpg.helpers.dice.{HundredSidedDice, TenSidedDice}
import com.rkss.rpg.coc.concepts.results._

private[behaviors] final case class SkillImprovement[A <: ImprovableSkillName](
    val skill: Skill[A] with SkillSuccessMark
)(implicit
    hundredSidedDice: HundredSidedDice,
    tenSidedDice: TenSidedDice
) {
  lazy val result: SkillImproved[A] = {
    val ImprovementChecked(rolled, improved) =
      ImprovementCheckExecutor.instance.skillImprovementCheck(skill)

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
