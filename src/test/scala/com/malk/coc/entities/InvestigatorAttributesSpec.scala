package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

import com.malk.coc.rules.HumanAgingRules
import com.malk.coc.generators.OccupationGenerator

class InvestigatorAttributesSpec extends AnyFunSpec with Matchers with MockFactory {
  import com.malk.coc.generators.InvestigatorAttributes.implicits._
  import com.malk.coc.generators.InvestigatorCharacteristics.implicits._
  import com.malk.coc.generators.InvestigatorOccupationTemplates.implicits._
  import com.malk.coc.helpers.DiceHelper.implicits._

  describe("Investigator Attributes") {
    val occupationTemplate = randomOccupationTemplate

    val occupation = OccupationGenerator(
      occupationTemplate
    )

    val implicitAge = age

    val humanAgingRules = new HumanAgingRules(implicitAge)

    val implicitBody = body

    val implicitBrain = brain

    val human = Investigator(
      implicitAge,
      implicitBody,
      app,
      edu,
      implicitBrain,
      luck,
      occupation.name,
      occupation.skills
    )(humanAgingRules)

    describe("Investigator attributes") {
      it("should have Age") {
        human.Age shouldBe implicitAge.value
      }

      describe("Investigator MovementRate (MOV)") {
        describe(
          s"when Age ${human.Age} - STR ${human.STR} - DEX ${human.DEX} - SIZ ${human.SIZ}"
        ) {

          val mov = humanAgingRules movFor implicitBody

          it(s"should have MOV ${mov.value}") {
            human.MOV shouldBe mov.value
          }

        }
      }

      describe("Investigator Current Hit Points (HP)") {
        val expected = implicitBody.maximumHitPoints.value

        it(
          s"should have Current Hit Points (HP) equal or inferior to ${expected}"
        ) {
          human.HP should be <= expected
        }
      }

      describe("Investigator Build") {
        it(s"should have Build") {
          human.Build should (be >= -2 and be <= 2)
        }
      }

      describe("Investigator Damage Bonus (DB)") {
        it(s"should have DB") {
          human.DB should (be >= -2 and be <= 5)
        }
      }

      describe("Magic Points (MP)") {
        val expected = implicitBrain.power.value / 5

        it(s"should have MP ${expected}") {
          human.MP shouldBe expected
        }
      }

      describe("Sanity (SAN)") {
        val expected = implicitBrain.power.value

        it(s"should have SAN ${expected}") {
          human.SAN shouldBe expected
        }
      }

      describe("Luck") {
        it(s"should have Luck") {
          human.Luck should be > 0
        }
      }

      describe("Occupation") {
        it(s"should have Luck") {
          human.occupationName should not be empty
        }
      }

      describe("Skills") {
        it(s"should have Skills") {
          human.skills should not be empty
        }
      }
    }
  }
}
