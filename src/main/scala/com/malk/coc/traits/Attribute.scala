package com.malk.coc.traits

abstract class Attribute(val name: String, val value: Int)

object Attribute {
  trait ChangeValue[A <: Attribute] {
    def -(other: Int): A

    def +(other: Int): A
  }
}