package com.malk.coc.concepts.attributes

import com.malk.coc.traits.Attribute

final case class Age(override val value: Int) extends Attribute {
  override val name: String = "Age"

  def -(minus: Int): Age = {
    this.copy(value - minus)
  }

  def +(plus: Int): Age = {
    this.copy(value + plus)
  }
}