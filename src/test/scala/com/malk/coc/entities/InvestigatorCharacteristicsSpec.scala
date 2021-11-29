package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

import com.malk.coc.concepts.dices._
import com.malk.coc.rules.HumanAgingRules
import com.malk.coc.concepts.dices.DiceRange
import com.malk.coc.generators.OccupationGenerator

class InvestigatorCharacteristicsSpec extends AnyFunSpec with Matchers with MockFactory {
  import com.malk.coc.generators.InvestigatorAttributes.implicits._
  import com.malk.coc.generators.InvestigatorCharacteristics.implicits._
  import com.malk.coc.generators.InvestigatorOccupationTemplates.implicits._
  import com.malk.coc.helpers.DiceHelper.implicits._

  describe("Investigator Characteristics") {
    val rollD10 = mockFunction[DiceRange, Int]
    implicit val tenSidedDice = TenSidedDice(rollD10)

    rollD10.stubs(DiceRange(1, 10)).returning(6)

    val rollD100 = mockFunction[DiceRange, Int]
    implicit val hundredSidedDice = HundredSidedDice(rollD100)

    rollD100.stubs(DiceRange(1, 100)).returning(78)

    val rollD6 = mockFunction[DiceRange, Int]
    implicit val sixSidedDice = SixSidedDice(rollD6)

    rollD6.stubs(DiceRange(1, 6)).returning(4)

    val rollD4 = mockFunction[DiceRange, Int]
    implicit val fourSidedDice = FourSidedDice(rollD4)

    rollD4.stubs(DiceRange(1, 4)).returning(2)

    val occupationTemplate = randomOccupationTemplate

    val occupation = OccupationGenerator(
      occupationTemplate
    )

    implicit val humanAgingRules = new HumanAgingRules(age)

    val human = Investigator(
      age,
      body,
      app,
      edu,
      brain,
      luck,
      occupation.name,
      occupation.skills
    )(humanAgingRules)

    describe("Education") {
      it("should have Education (EDU) above 0") {
        human.EDU should be > 0
      }
    }

    describe("Appearance") {
      it("should have Appearance (APP) above 0") {
        human.APP should be > 0
      }
    }

    describe("Strength") {
      it("should have Strength (STR) above 0") {
        human.STR should be > 0
      }
    }

    describe("Dexterity") {
      it("should have Dexterity (DEX) above 0") {
        human.DEX should be > 0
      }
    }

    describe("Constitution") {
      it("should have Constitution (CON) above 0") {
        human.CON should be > 0
      }
    }

    describe("Size") {
      it("should have Size (SIZ) above 0") {
        human.SIZ should be > 0
      }
    }

    describe("Intelligence") {
      it("should have Intelligence (INT) above 0") {
        human.INT should be > 0
      }
    }

    describe("Power") {
      it("should have Power (POW) above 0") {
        human.POW should be > 0
      }
    }
  }
}
