package com.rkss.rpg.coc.behaviors.executors

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.results._
import com.rkss.rpg.coc.concepts._

private[behaviors] final class ImprovementCheckExecutor private () {
  def improvementCheck[A <: ImprovableSkillName](skill: Skill[A])(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): ImprovementChecked = {
    val rolled = hundredSidedDice.roll.value
    val skillValue = skill.value()

    val improved = rolled match {
      case x if x > skillValue || x > 95 =>
          tenSidedDice.roll.value
      case _ =>
          0
    }

    ImprovementChecked(RollDiceResult(rolled), improved)
  }
}

private[behaviors] object ImprovementCheckExecutor {
  lazy val instance: ImprovementCheckExecutor = {
    new ImprovementCheckExecutor
  }
}
