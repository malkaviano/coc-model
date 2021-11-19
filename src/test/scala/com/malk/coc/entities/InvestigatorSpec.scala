package com.malk.coc.entities

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

import com.malk.coc.concepts.dices._
import com.malk.coc.occupations.Occupation
import com.malk.coc.helpers.SkillHelper

class InvestigatorSpec extends AnyFunSpec with Matchers with MockFactory {
  describe("Generating random investigator") {
    it("should create an Investigator") {
      import com.malk.coc.helpers.InvestigatorAttributes.implicits._
      import com.malk.coc.helpers.InvestigatorCharacteristics.implicits._
      import com.malk.coc.helpers.InvestigatorOccupationTemplates.implicits._
      import com.malk.coc.helpers.DiceHelper.implicits._

      val rollD10 = mockFunction[(Int, Int), Int]
      val tenSidedDice = TenSidedDice(rollD10)

      rollD10.stubs((1, 10)).returning(6)

      val rollD100 = mockFunction[(Int, Int), Int]
      val hundredSidedDice = HundredSidedDice(rollD100)

      rollD100.stubs((1, 100)).returning(78)

      val rollD6 = mockFunction[(Int, Int), Int]
      implicit val sixSidedDice = SixSidedDice(rollD6)

      rollD6.stubs((1, 6)).returning(4)

      val rollD4 = mockFunction[(Int, Int), Int]
      implicit val fourSidedDice = FourSidedDice(rollD4)

      rollD4.stubs((1, 4)).returning(2)

      val implicitBody = body
      val implicitApp = app
      val implicitEdu = edu
      val implicitBrain = brain

      val occupationTemplate = randomOccupationTemplate

      val occupationSkillPoints =
        occupationTemplate.occupationSkillPointsRule.occupationSkillPoints(
          implicitBody,
          implicitBrain,
          implicitEdu,
          implicitApp
        )

      val occupationSkills =
        occupationTemplate.fixedSkills ++ SkillHelper.chooseSkills(
          occupationTemplate.optionalSkills
        )

      val startCreditRating = occupationTemplate.startCreditRating

      /*
       TODO:
         1 - Spent points on occupation skills
         2 - Default skills = Common Skills - occupationSkills - CreditRating
         3 - Add occupation skills and credit rating to reserved skills
         4 - Spent personal points
       */

      val creditRating = SkillHelper.spendPointsOnCreditRating(
        occupationTemplate.startCreditRating,
        occupationTemplate.maximumCreditRating,
        occupationSkillPoints
      )

      val occupation = Occupation(
        occupationTemplate.name,
        occupationSkills + creditRating,
        startCreditRating
      )

      Investigator(
        age,
        implicitBody,
        implicitApp,
        implicitEdu,
        implicitBrain,
        luck,
        occupation
      )(fourSidedDice, sixSidedDice, tenSidedDice, hundredSidedDice)

      pending
    }
  }
}
