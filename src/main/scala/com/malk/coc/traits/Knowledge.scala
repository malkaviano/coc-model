package com.malk.coc.traits

import com.malk.coc.concepts.characteristics.Age
import com.malk.coc.helpers.Dice

trait Knowledge {
  def EDU: Int
}

object EducationImprovement {
  implicit def eduImprover(age: Age): Int = {
    if (age.value < 20) {
      Dice.roll10 * -1
    } else if (age.value >= 40) {
      val x = age.value - 40

      1 to ((x / 10) + 1) map { _ => Dice.roll10 } reduce { _ + _ }
    } else {
      0
    }
  }
}
