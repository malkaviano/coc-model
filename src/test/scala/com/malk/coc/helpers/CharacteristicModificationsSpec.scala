package com.malk.coc.helpers

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.malk.coc.helpers.CharacteristicModifications._
import com.malk.coc.concepts.characteristics._
import com.malk.coc.traits.Characteristic
import com.malk.coc.concepts.dices.DiceRange

class CharacteristicModificationsSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.helpers.CharacteristicModifications.implicits._

  describe("Characteristics Modification") {
    val value = DiceHelper.rollRange(DiceRange(1, 10))

    describe(s"StrengthModification implicitly from ${value}") {
      val expected = Modification[Strength](value)

      val cm: Modification[Strength] = value

      behavesLikeCharacteristicModification(cm, expected)
    }

    describe(s"ConstitutionModification implicitly from ${value}") {
      val expected = Modification[Constitution](value)

      val cm: Modification[Constitution] = value

      behavesLikeCharacteristicModification(cm, expected)
    }

    describe(s"DexterityModification implicitly from ${value}") {
      val expected = Modification[Dexterity](value)

      val cm: Modification[Dexterity] = value

      behavesLikeCharacteristicModification(cm, expected)
    }

    describe(s"SizeModification implicitly from ${value}") {
      val expected = Modification[Size](value)

      val cm: Modification[Size] = value

      behavesLikeCharacteristicModification(cm, expected)
    }

    describe(s"AppearanceModification implicitly from ${value}") {
      val expected = Modification[Appearance](value)

      val cm: Modification[Appearance] = value

      behavesLikeCharacteristicModification(cm, expected)
    }

    describe(s"IntelligenceModification implicitly from ${value}") {
      val expected = Modification[Intelligence](value)

      val cm: Modification[Intelligence] = value

      behavesLikeCharacteristicModification(cm, expected)
    }

    describe(s"PowerModification implicitly from ${value}") {
      val expected = Modification[Power](value)

      val cm: Modification[Power] = value

      behavesLikeCharacteristicModification(cm, expected)
    }
  }

  def behavesLikeCharacteristicModification[A <: Characteristic](
      modification: Modification[A],
      expected: Modification[A]
  ) = {
    it(s"should return ${expected}") {
      modification.name shouldBe expected.name
      modification.value shouldBe expected.value
    }
  }
}
