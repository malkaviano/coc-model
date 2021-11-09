package com.malk.coc.rules

import com.malk.coc.concepts.characteristics.Age
import com.malk.coc.concepts.characteristics.Education

import com.malk.coc.helpers.Dice
import scala.annotation.tailrec

class HumanAgingOnEducation(
    protected val age: Age,
    protected val edu: Education,
    protected val roll100: () => Int = () => Dice.roll100,
    protected val roll10: () => Int = () => Dice.roll10
) {
  val modifiedEducation: Education = age.value match {
    case x if x < 20 => edu.copy(edu.value - 5)
    case x if x >= 50 => checkEDUIncrease(edu, 3)
    case x if x >= 40 => checkEDUIncrease(edu, 2)
    case _ => checkEDUIncrease(edu)
  }

  @tailrec
  private def checkEDUIncrease(edu: Education, times: Int = 1): Education = {
    val newEdu = if (roll100() > edu.value) edu.copy(edu.value + roll10()) else edu

    if (times == 1) newEdu else checkEDUIncrease(newEdu, times - 1)
  }
}
