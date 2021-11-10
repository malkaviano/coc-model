package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.concepts.characteristics.Size
import com.malk.coc.helpers.Dice
import com.malk.coc.concepts.characteristics.Age

trait MovementRateBehaviors extends Matchers { this: AnyFunSpec =>
  def calculateMovementRate(
      age: Age,
      str: Strength,
      dex: Dexterity,
      siz: Size,
      expected: Int
  ) {
    describe(s"when ${str} - ${dex} - ${siz}") {
      val mobility = new HumanMobility(age, str, dex, siz)

      it(s"should return value ${expected}") {
        mobility.MOV shouldBe expected
      }
    }
  }
}

class HumanMobilitySpec extends AnyFunSpec with MovementRateBehaviors {
  describe("Human MOV calculation") {
    describe("Human age is bellow 40") {
      val age = Dice.randomAge(15, 39)

      suit(age, 0)
    }

    describe("Human age is in the 40s") {
      val age = Dice.randomAge(40, 49)

      describe("deduct MOV by 1") {
        suit(age, 1)
      }
    }

    describe("Human age is in the 50s") {
      val age = Dice.randomAge(50, 59)

      describe("deduct MOV by 2") {
        suit(age, 2)
      }
    }

    describe("Human age is in the 60s") {
      val age = Dice.randomAge(60, 69)

      describe("deduct MOV by 3") {
        suit(age, 3)
      }
    }

    describe("Human age is in the 70s") {
      val age = Dice.randomAge(70, 79)

      describe("deduct MOV by 4") {
        suit(age, 4)
      }
    }

    describe("Human age is in the 80s") {
      val age = Dice.randomAge(80, 89)

      describe("deduct MOV by 5") {
        suit(age, 5)
      }
    }
  }

  private def check(
      age: Age,
      str: Strength,
      dex: Dexterity,
      siz: Size,
      expected: Int
  ) = {
    it should behave like calculateMovementRate(
      age,
      str,
      dex,
      siz,
      expected
    )
  }

  private def suit(age: Age, reduction: Int) = {
    Seq(
      (Strength(60), Dexterity(70), Size(50), 9 - reduction),
      (Strength(24), Dexterity(48), Size(50), 7 - reduction),
      (Strength(50), Dexterity(50), Size(50), 8 - reduction),
      (Strength(40), Dexterity(60), Size(50), 8 - reduction),
      (Strength(55), Dexterity(30), Size(50), 8 - reduction),
      (Strength(50), Dexterity(30), Size(50), 8 - reduction),
      (Strength(40), Dexterity(50), Size(50), 8 - reduction)
    ).foreach {
      case (str, dex, siz, expected) => {
        check(age, str, dex, siz, expected)
      }
    }
  }
}
