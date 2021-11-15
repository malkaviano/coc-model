package com.malk.coc.helpers

import com.malk.coc.concepts.characteristics._
import com.malk.coc.traits.Characteristic
import scala.reflect.ClassTag

object CharacteristicModifications {
  final case class Modification[A <: Characteristic : ClassTag](value: Int) {
    val name = implicitly[ClassTag[A]].runtimeClass.getName()
  }

  object implicits {

    implicit def intToStrengthModification(
        value: Int
    ): Modification[Strength] =
      Modification[Strength](value)

    implicit def intToConstitutionModification(
        value: Int
    ): Modification[Constitution] =
      Modification[Constitution](value)

    implicit def intToDexterityModification(
        value: Int
    ): Modification[Dexterity] =
      Modification[Dexterity](value)

    implicit def intToSizeModification(
        value: Int
    ): Modification[Size] =
      Modification[Size](value)

    implicit def intToEducationModification(
        value: Int
    ): Modification[Education] =
      Modification[Education](value)

    implicit def intToPowerModification(
        value: Int
    ): Modification[Power] =
      Modification[Power](value)

    implicit def intToIntelligenceModification(
        value: Int
    ): Modification[Intelligence] =
      Modification[Intelligence](value)

    implicit def intToAppearanceModification(
        value: Int
    ): Modification[Appearance] =
      Modification[Appearance](value)
  }
}
