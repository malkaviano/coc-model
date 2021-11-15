package com.malk.coc.traits

import com.malk.coc.concepts.characteristics._

abstract class Characteristic(val name: String, val value: Int)

object Characteristic {
  object implicits {
    implicit def toStrength(value: Int): Strength = Strength(value)
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
}
