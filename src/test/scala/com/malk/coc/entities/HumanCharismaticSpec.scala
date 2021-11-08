package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics._

class HumanCharismaticSpec extends AnyFunSpec with Matchers {
  describe("The Human APP") {
    val str = Strength(50)
    val siz = Size(60)
    val dex = Dexterity(70)
    val con = Constitution(45)
    val app = Appearance(65)

    val human = new Human(
      Age(39),
      str,
      siz,
      dex,
      con,
      app,
    ) {}

    describe("when Human Age is bellow 40") {
      it("should have base APP not affected by Age") {
        human.APP shouldBe 65
      }
    }

    describe("when Human Age is in the 40's") {
      val human = new Human(
        Age(42),
        str,
        siz,
        dex,
        con,
        app
      ) {}

      it("should reduce 5 from the base APP") {
        human.APP shouldBe 60
      }
    }

    describe("when Human Age is in the 50's") {
      val human = new Human(
        Age(50),
        str,
        siz,
        dex,
        con,
        app
      ) {}

      it("should reduce 10 from the base APP") {
        human.APP shouldBe 55
      }
    }

    describe("when Human Age is in the 60's") {
      val human = new Human(
        Age(69),
        str,
        siz,
        dex,
        con,
        app
      ) {}

      it("should reduce 15 from the base APP") {
        human.APP shouldBe 50
      }
    }

    describe("when Human Age is in the 70's") {
      val human = new Human(
        Age(74),
        str,
        siz,
        dex,
        con,
        app
      ) {}

      it("should reduce 20 from the base APP") {
        human.APP shouldBe 45
      }
    }

    describe("when Human Age is in the 80's") {
      val human = new Human(
        Age(82),
        str,
        siz,
        dex,
        con,
        app
      ) {}

      it("should reduce 25 from the base APP") {
        human.APP shouldBe 40
      }
    }
  }
}
