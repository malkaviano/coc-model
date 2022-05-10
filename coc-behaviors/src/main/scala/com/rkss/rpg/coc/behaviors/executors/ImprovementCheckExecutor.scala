package com.rkss.rpg.coc.behaviors.executors

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.results._
import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.concepts.characteristic._

private[behaviors] final class ImprovementCheckExecutor private () {
  def skillImprovementCheck[A <: ImprovableSkillName](skill: Skill[A])(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): ImprovementChecked = {
    val rolled = hundredSidedDice.roll.value
    val skillValue = skill.value()

    improvementCheck(rolled, skillValue)
  }

  def characteristicCheck[A <: ImprovableCharacteristicName](
      characteristic: Characteristic[A]
  )(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): ImprovementChecked = {
    val rolled = hundredSidedDice.roll.value
    val value = characteristic.value()

    improvementCheck(rolled, value)
  }

  private def improvementCheck(rolled: Int, value: Int)(implicit
      tenSidedDice: TenSidedDice
  ): ImprovementChecked = {
    val improved = rolled match {
      case x if x > value || x > 95 =>
        tenSidedDice.roll.value
      case _ =>
        0
    }

    ImprovementChecked(DiceRolled(rolled), improved)
  }
}

private[behaviors] object ImprovementCheckExecutor {
  lazy val instance: ImprovementCheckExecutor = {
    new ImprovementCheckExecutor
  }
}
