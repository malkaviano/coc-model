package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics._
import com.malk.coc.traits.EducationImprovement._
import com.malk.coc.helpers.Dice
import com.malk.coc.rules.HumanAgingOnEducation

class HumanSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.rules.HumanAgingOnEducation.implicits._

  describe("The Human spec") {
    val age = Dice.randomAge()
    val str = Strength(50)
    val siz = Size(60)
    val dex = Dexterity(70)
    val con = Constitution(45)
    val app = Appearance(65)
    val edu = Education(48)

    val human = new Human(
      age,
      str,
      siz,
      dex,
      con,
      app,
      edu
    ) {}

    it("should have Age") {
      human.Age shouldBe age.value
    }

    describe("The Human characteristics") {
      it("should have Education (EDU) above 0") {
        human.EDU should be > 0
      }

      it("should have initial Education (EDU) modified by Age") {
        val roll10 = () => 5
        val roll100 = () => 99

        val ageEffect = new HumanAgingOnEducation(roll100, roll10)

        val human = new Human(
          age,
          str,
          siz,
          dex,
          con,
          app,
          edu
        )(ageEffect) {}

        human.EDU shouldBe ageEffect.modifiedEducation(age, edu).value
      }

      it("should have Appearance (APP) above 0") {
        human.APP should be > 0
      }

      it("should have Strength (STR) above 0") {
        human.STR should be > 0
      }

      it("should have Strength (DEX) above 0") {
        human.DEX should be > 0
      }

      it("should have Strength (CON) above 0") {
        human.CON should be > 0
      }

      it("should have Strength (SIZ) above 0") {
        human.SIZ should be > 0
      }
    }

  }
}
