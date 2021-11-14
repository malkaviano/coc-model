package com.malk.coc.rules

import scala.annotation.tailrec

import com.malk.coc.concepts.characteristics.Age
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.traits.AgingEffectOnEducation
import com.malk.coc.concepts.dices.DeltohedronDice
import com.malk.coc.concepts.dices.HundredSidedDice

class HumanAgingEffectOnEducation(
    protected val hundredSidedDice: HundredSidedDice,
    protected val deltohedronDice: DeltohedronDice
) extends AgingEffectOnEducation {
  def modifiedEducation(age: Age, edu: Education): Education = {
    val result = age.value match {
      case x if x < 20  => edu.copy(edu.value - 5)
      case x if x >= 60 => checkEDUIncrease(edu, 4)
      case x if x >= 50 => checkEDUIncrease(edu, 3)
      case x if x >= 40 => checkEDUIncrease(edu, 2)
      case _            => checkEDUIncrease(edu)
    }

    if (result.value >= 100) Education(99) else result
  }

  @tailrec
  private def checkEDUIncrease(edu: Education, times: Int = 1): Education = {
    val newEdu =
      if (hundredSidedDice.roll > edu.value) edu + deltohedronDice.roll else edu

    if (times == 1) newEdu else checkEDUIncrease(newEdu, times - 1)
  }
}

object HumanAgingEffectOnEducation {
  object implicits {
    import com.malk.coc.helpers.DiceHelper.implicits._

    implicit val humanAgingOnEducationEffect: HumanAgingEffectOnEducation =
      new HumanAgingEffectOnEducation(hundredSidedDice, deltohedronDice)
  }
}
