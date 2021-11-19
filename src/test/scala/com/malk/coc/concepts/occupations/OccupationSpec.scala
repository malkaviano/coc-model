package com.malk.coc.concepts.occupations

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.occupations.Occupation

class OccupationSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.helpers.InvestigatorCharacteristics.implicits._
  import com.malk.coc.helpers.DiceHelper.implicits._

  describe("Occupation") {
    val template = new TribeMemberTemplate
    val implicitBody = body
    val implicitBrain = brain
    val implicitEdu = edu
    val implicitApp = app

    val occupation = Occupation(
      template,
      implicitBody,
      implicitBrain,
      implicitEdu,
      implicitApp
    )

    it("should have name TRIBE MEMBER") {
      occupation.name shouldBe "TRIBE MEMBER"
    }

    describe("Skills") {
      it("should have skills") {
        occupation.skills should have size 9
      }

      val minCR = template.startCreditRating
      val maxCR = template.maximumCreditRating

      it(
        s"should have Credit Rating between ${minCR} and ${maxCR}"
      ) {
        val result = occupation.skills.filter(_.name == "Credit Rating").head

        result.value should (be >= minCR.value and be <= maxCR.value)
      }

      val occupationSkillPoints =
        template.occupationSkillPointsRule.occupationSkillPoints(
          body,
          brain,
          edu,
          app
        )

      it(
        s"should have all skills with points spent"
      ) {
        val result = occupation.skills.map(_.value).reduce(_ + _)

        result shouldBe occupationSkillPoints
      }
    }
  }
}
