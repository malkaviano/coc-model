package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics._

class HumanMobilitySpec extends AnyFunSpec with Matchers {
  describe("The Human entity") {
    val str = Strength(50)
    val siz = Size(60)
    val dex = Dexterity(70)
    val baseMOV = 8

    val human = new Human(
      Age(39),
      str,
      siz,
      dex
    ) {}

    describe("when Human Age is bellow 40") {
      it("should have base MOV not affected by Age") {
        human.MOV shouldBe baseMOV
      }
    }

    describe("when Human Age is in the 40's") {
      val human = new Human(
        Age(42),
        str,
        siz,
        dex
      ) {}

      it("should deduce 1 from the base MOV") {
        human.MOV shouldBe baseMOV - 1
      }
    }

    describe("when Human Age is in the 50's") {
      val human = new Human(
        Age(50),
        str,
        siz,
        dex
      ) {}

      it("should deduce 2 from the base MOV") {
        human.MOV shouldBe baseMOV - 2
      }
    }

    describe("when Human Age is in the 60's") {
      val human = new Human(
        Age(69),
        str,
        siz,
        dex
      ) {}

      it("should deduce 3 from the base MOV") {
        human.MOV shouldBe baseMOV - 3
      }
    }

    describe("when Human Age is in the 70's") {
      val human = new Human(
        Age(74),
        str,
        siz,
        dex
      ) {}

      it("should deduce 4 from the base MOV") {
        human.MOV shouldBe baseMOV - 4
      }
    }

    describe("when Human Age is in the 80's") {
      val human = new Human(
        Age(82),
        str,
        siz,
        dex
      ) {}

      it("should deduce 5 from the base MOV") {
        human.MOV shouldBe baseMOV - 5
      }
    }
  }
}
