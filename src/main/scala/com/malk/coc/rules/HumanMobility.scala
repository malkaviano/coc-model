package com.malk.coc.rules

import com.malk.coc.traits.Mobility
import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.concepts.characteristics.Size
import com.malk.coc.concepts.characteristics.Age

class HumanMobility(
    protected val age: Age,
    protected val str: Strength,
    protected val dex: Dexterity,
    protected val siz: Size
) extends Mobility {
  override val MOV: Int = {
    val result =
      if (str.value < siz.value && dex.value < siz.value)
        7
      else if (str.value > siz.value && dex.value > siz.value)
        9
      else
        8

    val delta = age.value - 40

    if (delta < 0) {
      result
    } else {
      result - ((delta / 10) + 1)
    }
  }
}
