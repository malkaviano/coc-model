package com.malk.coc.rules

import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.characteristics.Age

object HumanAgingEffectOnAppearance {
  implicit def appearance(age: Age, app: Appearance): Appearance = {
    val value = if (age.value < 40) {
      app.value
    } else {
      val x = age.value - 40

      app.value - ((x / 10) + 1) * 5
    }

    Appearance(value)
  }
}
