package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics._
import com.malk.coc.helpers.DiceHelper
import com.malk.coc.rules.HumanAgingEffectOnEducation
import com.malk.coc.rules.HumanMobility
import com.malk.coc.rules.HumanAgingEffectOnAppearance
import com.malk.coc.rules.HumanAgingEffectOnBody
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.concepts.dices.DeltohedronDice
import com.malk.coc.concepts.dices.HundredSidedDice

class HumanCharacteristicsSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.helpers.DiceHelper.implicits._
  import com.malk.coc.rules.HumanAgingEffectOnEducation.implicits._
  import com.malk.coc.rules.HumanMobility._
  import com.malk.coc.rules.HumanAgingEffectOnAppearance._
  import com.malk.coc.rules.HumanAgingEffectOnBody._

  describe("The Human Characteristics") {
    val age = DiceHelper.randomAge()
    val str = Strength(50)
    val siz = Size(60)
    val dex = Dexterity(70)
    val con = Constitution(45)
    val app = Appearance(65)
    val edu = Education(48)
    val luck = Luck(34)
    val int = Intelligence(56)
    val pow = Power(43)

    val body = Body(str, con, dex, siz)
    val brain = Brain(int, pow)

    val human = Human(
      age,
      body,
      app,
      edu,
      luck,
      brain
    )

    describe("The Human characteristics") {
      it("should have Education (EDU) above 0") {
        human.EDU should be > 0
      }

      it("should have initial Education (EDU) modified by Age") {
        val hundredSidedDice = HundredSidedDice((t: (Int, Int)) => 95)

        val deltohedronDice = DeltohedronDice((t: (Int, Int)) => 7)

        val ageEffect = new HumanAgingEffectOnEducation(hundredSidedDice, deltohedronDice)

        val human = Human(
          age,
          body,
          app,
          edu,
          luck,
          brain
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
          DiceHelper.randomAge(40, 49),
          body,
          app,
          edu,
          luck,
          brain
        )

        human.APP shouldBe 60
      }

      it("should have Strength (STR) above 0") {
        human.STR should be > 0
      }

      it("should have initial Strength (STR) modified by Age") {
        val human = Human(
          DiceHelper.randomAge(50, 59),
          body,
          app,
          edu,
          luck,
          brain
        )

        human.STR shouldBe 47
      }

      it("should have Dexterity (DEX) above 0") {
        human.DEX should be > 0
      }

      it("should have initial Dexterity (DEX) modified by Age") {
        val human = Human(
          DiceHelper.randomAge(50, 59),
          body,
          app,
          edu,
          luck,
          brain
        )

        human.DEX shouldBe 66
      }

      it("should have Constitution (CON) above 0") {
        human.CON should be > 0
      }

      it("should have initial Constitution (CON) modified by Age") {
        val human = Human(
          DiceHelper.randomAge(50, 59),
          body,
          app,
          edu,
          luck,
          brain
        )

        human.CON shouldBe 42
      }

      it("should have Size (SIZ) above 0") {
        human.SIZ should be > 0
      }

      it("should have initial Size (SIZ) modified by young Age") {
        val human = Human(
          DiceHelper.randomAge(15, 19),
          body,
          app,
          edu,
          luck,
          brain
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
