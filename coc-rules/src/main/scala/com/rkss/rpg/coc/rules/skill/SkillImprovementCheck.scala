package com.rkss.rpg.coc.rules.skill

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDiceResult

private final class SkillImprovementCheck private () {
  def improvementCheck[A <: SkillName](skill: Skill[A])(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): SkillImproved = {
    val increment = tenSidedDice.roll.value
    val skillValue = skill.value()
    val rolled = hundredSidedDice.roll.value

    rolled match {
      case x if x > skillValue || x > 95 =>
        SkillImproved(
          skill.name,
          skill.value(),
          increment,
          Option(SkillRollDiceResult(rolled)),
          skillValue < 90 && skillValue + increment >= 90
        )
      case _ =>
        SkillImproved(
          skill.name,
          skill.value(),
          0,
          Option(SkillRollDiceResult(rolled)),
          false
        )
    }
  }
}

private object SkillImprovementCheck {
  lazy val instance: SkillImprovementCheck = {
    new SkillImprovementCheck
  }
}
