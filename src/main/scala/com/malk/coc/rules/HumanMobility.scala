package com.malk.coc.rules

import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.concepts.characteristics.Size
import com.malk.coc.concepts.characteristics.Age
import com.malk.coc.concepts.attributes.MovementRate

object HumanMobility {
  implicit def movementRate(
      age: Age,
      str: Strength,
      dex: Dexterity,
      siz: Size
  ): MovementRate = {
    val result =
      if (str.value < siz.value && dex.value < siz.value)
        7
      else if (str.value > siz.value && dex.value > siz.value)
        9
      else
        8

    val delta = age.value - 40

    val value = if (delta < 0) {
      result
    } else {
      result - ((delta / 10) + 1)
    }

    MovementRate(value)
  }
}
