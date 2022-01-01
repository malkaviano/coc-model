package com.rkss.rpg.coc.rules

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.helpers.traits.DiceResult
import com.rkss.rpg.coc.concepts.skill.improvement._

private final class SkillImprovementCheck private () {
  def improvementCheck(skill: Skill)(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): SkillImproved = {
    val none = SkillImproved(skill, 0, Option.empty[DiceResult], false)

    val increment = tenSidedDice.roll.value
    val skillValue = skill.value()
    val rolled = hundredSidedDice.roll

    rolled.value match {
      case x if x > skillValue || x > 95 =>
        SkillImproved(
          skill,
          increment,
          Option(rolled),
          skillValue < 90 && skillValue + increment >= 90
        )
      case _ => none.copy(rolled = Option(rolled))
    }
  }
}

private object SkillImprovementCheck {
  lazy val instance: SkillImprovementCheck = {
    new SkillImprovementCheck
  }
}
