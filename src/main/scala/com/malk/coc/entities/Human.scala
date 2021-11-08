package com.malk.coc.entities

import com.malk.coc.concepts.characteristics._
import com.malk.coc.traits._
import com.malk.coc.concepts.attributes.MovementRate

abstract class Human(
    protected val age: Age,
    protected val str: Strength,
    protected val siz: Size,
    protected val dex: Dexterity
) extends Mobility {
  protected val mov: MovementRate = MovementRate(str, dex, siz)

  override def MOV: Int = {
    val x = (age.value - 40)

    if (x < 0)
      mov.value
    else
      mov.value - ((x / 10) + 1)
  }
}
