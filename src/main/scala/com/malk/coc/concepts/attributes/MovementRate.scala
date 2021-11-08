package com.malk.coc.concepts.attributes

import com.malk.coc.concepts.characteristics.{Dexterity, Strength, Size}

case class MovementRate(
  private val str: Strength,
  private val dex: Dexterity,
  private val siz: Size
) extends Attribute("MOV") {
  override def value: Int = {
    if (str.value < siz.value && dex.value < siz.value)
      7
    else if (str.value > siz.value && dex.value > siz.value)
      9
    else
      8
  }
}