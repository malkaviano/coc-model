package com.malk.coc.traits

import com.malk.coc.helpers.CharacteristicModifications.Modification

abstract class Characteristic(val name: String, val value: Int)

object Characteristic {
  trait Modifications[A <: Characteristic] {
    def -(other: Modification[A]): A

    def +(other: Modification[A]): A
  }
}
