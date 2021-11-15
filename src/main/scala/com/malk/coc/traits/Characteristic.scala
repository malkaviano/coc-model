package com.malk.coc.traits

import com.malk.coc.concepts.characteristics._
import com.malk.coc.helpers.CharacteristicModifications.Modification

abstract class Characteristic(val name: String, val value: Int)

object Characteristic {
  object implicits {
    implicit def toSize(value: Int): Size = Size(value)
    implicit def toPower(value: Int): Power = Power(value)
    implicit def toIntelligence(value: Int): Intelligence = Intelligence(value)
    implicit def toEducation(value: Int): Education = Education(value)
    implicit def toAppearance(value: Int): Appearance = Appearance(value)
    implicit def toConstitution(value: Int): Constitution = Constitution(value)
    implicit def toDexterity(value: Int): Dexterity = Dexterity(value)
  }

  trait MathOperations[A <: Characteristic] {
    def -(other: A): A

    def +(other: A): A
  }

  trait Modifications[A <: Characteristic] {
    def -(other: Modification[A]): A

    def +(other: Modification[A]): A
  }
}
