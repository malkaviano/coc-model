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

    val occupationSkillPoints =
      template.occupationSkillPointsRule.occupationSkillPoints(
        implicitBody,
        implicitBrain,
        implicitEdu,
        implicitApp
      )

    val personalInterestPoints =
      InvestigatorSkillPoints(implicitBrain.intelligence.value * 2)

    describe(s"when ${occupationSkillPoints}") {
      val minCR = template.startCreditRating
      val maxCR = template.maximumCreditRating

      it(
        s"should have Credit Rating between ${minCR.value} and ${maxCR.value}"
      ) {
        val result = occupation.skills.filter(_.name == "Credit Rating").head

        result.value should (be >= minCR.value and be <= maxCR.value)
      }

      it(
        s"should have spent all occupation skills points"
      ) {
        val resultSkills = occupation.skills.toSeq

        val skillValues = resultSkills.map(_.value).reduce(_ + _)
        val baseValues = resultSkills.map(_.base).reduce(_ + _)
        val spentOnSkills = skillValues - baseValues

        val result =
          (occupationSkillPoints.remaining + personalInterestPoints.remaining) - spentOnSkills

        result shouldBe 0
      }
    }
  }
}
