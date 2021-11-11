package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics._
import com.malk.coc.helpers.Dice
import com.malk.coc.rules.HumanAgingEffectOnEducation
import com.malk.coc.rules.HumanMobility
import com.malk.coc.rules.HumanAgingEffectOnAppearance
import com.malk.coc.rules.HumanAgingEffectOnBody

class HumanSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.rules.HumanAgingEffectOnEducation.implicits._
  import com.malk.coc.rules.HumanMobility._
  import com.malk.coc.rules.HumanAgingEffectOnAppearance._
  import com.malk.coc.rules.HumanAgingEffectOnBody._

  describe("The Human spec") {
    val age = Dice.randomAge()
    val str = Strength(50)
    val siz = Size(60)
    val dex = Dexterity(70)
    val con = Constitution(45)
    val app = Appearance(65)
    val edu = Education(48)
    val luck = Luck(34)
    val int = Intelligence(56)
    val pow = Power(43)

    val human = Human(
      age,
      str,
      siz,
      dex,
      con,
      app,
      edu,
      luck,
      int,
      pow
    )

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

        val ageEffect = new HumanAgingEffectOnEducation(roll100, roll10)

        val human = Human(
          age,
          str,
          siz,
          dex,
          con,
          app,
          edu,
          luck,
          int,
          pow
        )(
          agingEffectOnEducation = ageEffect,
          agingEffectOnAppearanceModifier =
            HumanAgingEffectOnAppearance.appearance,
          agingEffectOnBody = HumanAgingEffectOnBody.modifiedBody,
          movementRateGenerator = HumanMobility.movementRate
        )

        human.EDU shouldBe ageEffect.modifiedEducation(age, edu).value
      }

      it("should have Appearance (APP) above 0") {
        human.APP should be > 0
      }

      it("should have initial Appearance (APP) modified by Age") {
        val human = Human(
          Dice.randomAge(40, 49),
          str,
          siz,
          dex,
          con,
          app,
          edu,
          luck,
          int,
          pow
        )

        human.APP shouldBe 60
      }

      it("should have Strength (STR) above 0") {
        human.STR should be > 0
      }

      it("should have initial Strength (STR) modified by Age") {
        val human = Human(
          Dice.randomAge(50, 59),
          str,
          siz,
          dex,
          con,
          app,
          edu,
          luck,
          int,
          pow
        )

        human.STR shouldBe 47
      }

      it("should have Dexterity (DEX) above 0") {
        human.DEX should be > 0
      }

      it("should have initial Dexterity (DEX) modified by Age") {
        val human = Human(
          Dice.randomAge(50, 59),
          str,
          siz,
          dex,
          con,
          app,
          edu,
          luck,
          int,
          pow
        )

        human.DEX shouldBe 66
      }

      it("should have Constitution (CON) above 0") {
        human.CON should be > 0
      }

      it("should have initial Constitution (CON) modified by Age") {
        val human = Human(
          Dice.randomAge(50, 59),
          str,
          siz,
          dex,
          con,
          app,
          edu,
          luck,
          int,
          pow
        )

        human.CON shouldBe 42
      }

      it("should have Size (SIZ) above 0") {
        human.SIZ should be > 0
      }

      it("should have initial Size (SIZ) modified by young Age") {
        val human = Human(
          Dice.randomAge(15, 19),
          str,
          siz,
          dex,
          con,
          app,
          edu,
          luck,
          int,
          pow
        )

        human.SIZ shouldBe 58
      }

      it("should have Luck above 0") {
        human.Luck should be > 0
      }

      it("should have Intelligence (INT) above 0") {
        human.INT should be > 0
      }

      it("should have Power (POW) above 0") {
        human.POW should be > 0
      }
    }

  }
}
