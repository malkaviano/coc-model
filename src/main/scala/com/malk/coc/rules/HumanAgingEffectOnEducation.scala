package com.malk.coc.rules

import scala.annotation.tailrec

import com.malk.coc.concepts.characteristics.Age
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.helpers.DiceHelper
import com.malk.coc.traits.AgingEffectOnEducation

class HumanAgingEffectOnEducation(
    protected val roll100: () => Int = () => DiceHelper.roll100,
    protected val roll10: () => Int = () => DiceHelper.roll10
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
      if (roll100() > edu.value) edu.copy(edu.value + roll10()) else edu

    if (times == 1) newEdu else checkEDUIncrease(newEdu, times - 1)
  }
}

object HumanAgingEffectOnEducation {
  object implicits {
    implicit val humanAgingOnEducationEffect: HumanAgingEffectOnEducation =
      new HumanAgingEffectOnEducation
  }
}
