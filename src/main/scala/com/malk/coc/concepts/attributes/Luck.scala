package com.malk.coc.concepts.attributes

import com.malk.coc.traits.Attribute

final case class Luck(val value: Int) extends Attribute {
  val name = "Luck"

  def -(minus: Int): Luck = {
    this.copy(value - minus)
  }

  def +(plus: Int): Luck = {
    this.copy(value + plus)
  }
}