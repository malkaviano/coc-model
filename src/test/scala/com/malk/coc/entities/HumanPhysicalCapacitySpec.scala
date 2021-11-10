package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics._

class HumanPhysicalCapacitySpec extends AnyFunSpec with Matchers {
  import com.malk.coc.rules.HumanAgingEffectOnEducation.implicits._
  import com.malk.coc.rules.HumanMobility._

  describe("The Human physical capacity") {
    val str = Strength(50)
    val siz = Size(60)
    val dex = Dexterity(70)
    val con = Constitution(45)
    val app = Appearance(65)
    val edu = Education(48)

    val human = new Human(
      Age(39),
      str,
      siz,
      dex,
      con,
      app,
      edu
    ) {}

    describe("when Human Age is bellow 40") {
      it("should return base values of STR, CON, DEX and SIZ") {
        human.STR shouldBe 50
        human.DEX shouldBe 70
        human.CON shouldBe 45
        human.SIZ shouldBe 60
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
      ) {}

      it("should return base values of SIZ and 95% of STR, CON and DEX") {
        human.STR shouldBe 47
        human.DEX shouldBe 66
        human.CON shouldBe 42
        human.SIZ shouldBe 60
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
      ) {}

      it("should return base values of SIZ and 90% of STR, CON and DEX") {
        human.STR shouldBe 45
        human.DEX shouldBe 63
        human.CON shouldBe 40
        human.SIZ shouldBe 60
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
      ) {}

      it("should return base values of SIZ and 85% of STR, CON and DEX") {
        human.STR shouldBe 42
        human.DEX shouldBe 59
        human.CON shouldBe 38
        human.SIZ shouldBe 60
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
      ) {}

      it("should return base values of SIZ and 65% of STR, CON and DEX") {
        human.STR shouldBe 32
        human.DEX shouldBe 45
        human.CON shouldBe 29
        human.SIZ shouldBe 60
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
      ) {}

      it("should return base values of SIZ and 45% of STR, CON and DEX") {
        human.STR shouldBe 22
        human.DEX shouldBe 31
        human.CON shouldBe 20
        human.SIZ shouldBe 60
      }
    }
  }
}
