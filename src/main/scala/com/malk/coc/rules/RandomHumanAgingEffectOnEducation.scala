package com.malk.coc.rules

import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.characteristics.Age
import com.malk.coc.helpers.Dice
import com.malk.coc.traits.AgingEffectOnEducation

class RandomHumanAgingEffectOnEducation(
    protected val roll10: () => Int = () => Dice.roll10
) extends AgingEffectOnEducation {
  def modifiedEducation(age: Age, edu: Education): Education = {
    val result = if (age.value < 20) {
      edu.copy(edu.value - roll10())
    } else if (age.value >= 40) {
      val x = age.value - 40

      val increment = 1 to ((x / 10) + 1) map { _ => roll10() } reduce { _ + _ }

      edu.copy(edu.value + increment)
    } else {
      edu
    }

    if (result.value >= 100) {
      Education(99)
    } else {
      result
    }
  }
}
