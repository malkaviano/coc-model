package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.{Strength, Dexterity, Size}

trait MovementRateBehaviors extends Matchers { this: AnyFunSpec =>
  def calculateMovementRate(str: Strength, dex: Dexterity, siz: Size, expected: Int) {
    it(s"should return value ${expected} when ${str} ${dex} ${siz}") {
      MovementRate(str, dex, siz).value shouldBe expected
    }
  }
}

class MovementRateSpec extends AnyFunSpec with Matchers with MovementRateBehaviors {
  describe("The MovementRate") {
    val hp = MovementRate(str = Strength(40), Dexterity(60), siz = Size(60))

    it("should have name MOV") {
      hp.name shouldBe "MOV"
    }

    it should behave like calculateMovementRate(Strength(24), Dexterity(48), Size(50), 7)
    it should behave like calculateMovementRate(Strength(50), Dexterity(50), Size(50), 8)
    it should behave like calculateMovementRate(Strength(40), Dexterity(60), Size(50), 8)
    it should behave like calculateMovementRate(Strength(55), Dexterity(30), Size(50), 8)
    it should behave like calculateMovementRate(Strength(50), Dexterity(30), Size(50), 8)
    it should behave like calculateMovementRate(Strength(40), Dexterity(50), Size(50), 8)
    it should behave like calculateMovementRate(Strength(60), Dexterity(70), Size(50), 9)
  }
}