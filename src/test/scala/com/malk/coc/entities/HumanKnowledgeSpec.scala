package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics._
import com.malk.coc.traits.EducationImprovement._

class HumanKnowledgeSpec extends AnyFunSpec with Matchers {
  import scala.collection.mutable

  describe("The Human EDU") {
    val str = Strength(50)
    val siz = Size(60)
    val dex = Dexterity(70)
    val con = Constitution(45)
    val app = Appearance(65)
    val edu = Education(58)

    val human = new Human(
      Age(39),
      str,
      siz,
      dex,
      con,
      app,
      edu
    )(_ => 0) {}

    describe("when Human Age is between 20 and 39") {
      it("should have base EDU not affected by Age") {
        human.EDU shouldBe 58
      }
    }

    describe("when Human Age is bellow 20") {
      val human = new Human(
        Age(18),
        str,
        siz,
        dex,
        con,
        app,
        edu
      )(_ => -10) {}

      it("should subtract 1D10 to the base EDU") {
        human.EDU shouldBe 48
      }
    }

    describe("when Human Age is in the 40's") {
      val human = new Human(
        Age(42),
        str,
        siz,
        dex,
        con,
        app,
        edu
      )(_ => 6) {}

      it("should add 1D10 to the base EDU") {
        human.EDU shouldBe 64
      }
    }

    describe("when Human Age is in the 50's") {
      val human = new Human(
        Age(50),
        str,
        siz,
        dex,
        con,
        app,
        edu
      )(_ => 11) {}

      it("should add 2D10 to the base EDU") {
        human.EDU shouldBe 69
      }
    }

    describe("when Human Age is in the 60's") {
      val human = new Human(
        Age(69),
        str,
        siz,
        dex,
        con,
        app,
        edu
      )(_ => 23) {}

      it("should add 3D10 to the base EDU") {
        human.EDU shouldBe 81
      }
    }

    describe("when Human Age is in the 70's") {
      val human = new Human(
        Age(74),
        str,
        siz,
        dex,
        con,
        app,
        edu
      )(_ => 32) {}

      it("should add 4D10 to the base EDU") {
        human.EDU shouldBe 90
      }
    }

    describe("when Human Age is in the 80's") {
      val human = new Human(
        Age(82),
        str,
        siz,
        dex,
        con,
        app,
        edu
      )(_ => 45) {}

      it("should add 5D10 to the base EDU") {
        human.EDU shouldBe 99
      }
    }
  }
}
