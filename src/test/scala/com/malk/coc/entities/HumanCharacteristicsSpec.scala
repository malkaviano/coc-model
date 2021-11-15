package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics._
import com.malk.coc.helpers.DiceHelper
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.concepts.dices.DeltohedronDice
import com.malk.coc.concepts.dices.HundredSidedDice
import com.malk.coc.rules.HumanAgingRules
import com.malk.coc.concepts.attributes.Sanity
import com.malk.coc.concepts.attributes.MaximumMagicPoints

class HumanCharacteristicsSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.helpers.DiceHelper.implicits._

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

    implicit val humanAgingRules = new HumanAgingRules(age)

    val sanity = Sanity(70)

    val mp = MaximumMagicPoints(25)

    val human = Human(
      age,
      body,
      app,
      edu,
      luck,
      brain,
      sanity,
      mp
    )

    describe("Education") {
      it("should have Education (EDU) above 0") {
        human.EDU should be > 0
      }

      it("should have initial Education (EDU) modified by Age") {
        val hundredSidedDice = HundredSidedDice((t: (Int, Int)) => 95)

        val deltohedronDice = DeltohedronDice((t: (Int, Int)) => 7)

        val humanAgingRules = new HumanAgingRules(age)(
          tetrahedronDice,
          cubeDice,
          deltohedronDice,
          hundredSidedDice
        )

        val human = Human(
          age,
          body,
          app,
          edu,
          luck,
          brain,
          sanity,
          mp
        )(
          humanAgingRules
        )

        val expected = (humanAgingRules on edu).value

        human.EDU shouldBe expected
      }
    }

    describe("Appearance") {
      it("should have Appearance (APP) above 0") {
        human.APP should be > 0
      }

      it("should have initial Appearance (APP) modified by Age") {
        val age = DiceHelper.randomAge(40, 49)

        implicit val humanAgingRules = new HumanAgingRules(age)

        val human = Human(
          age,
          body,
          app,
          edu,
          luck,
          brain,
          sanity,
          mp
        )

        human.APP shouldBe 60
      }
    }

    describe("Strength") {
      it("should have Strength (STR) above 0") {
        human.STR should be > 0
      }

      it("should have initial Strength (STR) modified by Age") {
        val age = DiceHelper.randomAge(50, 59)

        implicit val humanAgingRules = new HumanAgingRules(age)

        val human = Human(
          age,
          body,
          app,
          edu,
          luck,
          brain,
          sanity,
          mp
        )

        human.STR shouldBe 47
      }
    }

    describe("Dexterity") {
      it("should have Dexterity (DEX) above 0") {
        human.DEX should be > 0
      }

      it("should have initial Dexterity (DEX) modified by Age") {
        val age = DiceHelper.randomAge(50, 59)

        implicit val humanAgingRules = new HumanAgingRules(age)

        val human = Human(
          age,
          body,
          app,
          edu,
          luck,
          brain,
          sanity,
          mp
        )

        human.DEX shouldBe 66
      }
    }

    describe("Constitution") {
      it("should have Constitution (CON) above 0") {
        human.CON should be > 0
      }

      it("should have initial Constitution (CON) modified by Age") {
        val age = DiceHelper.randomAge(50, 59)

        implicit val humanAgingRules = new HumanAgingRules(age)

        val human = Human(
          age,
          body,
          app,
          edu,
          luck,
          brain,
          sanity,
          mp
        )

        human.CON shouldBe 42
      }
    }

    describe("Size") {
      it("should have Size (SIZ) above 0") {
        human.SIZ should be > 0
      }

      it("should have initial Size (SIZ) modified by young Age") {
        val age = DiceHelper.randomAge(15, 19)

        implicit val humanAgingRules = new HumanAgingRules(age)

        val human = Human(
          age,
          body,
          app,
          edu,
          luck,
          brain,
          sanity,
          mp
        )

        human.SIZ shouldBe 58
      }
    }

    describe("Intelligence") {
      it("should have Intelligence (INT) above 0") {
        human.INT should be > 0
      }

      it("should have Power (POW) above 0") {
        human.POW should be > 0
      }
    }
  }
}
