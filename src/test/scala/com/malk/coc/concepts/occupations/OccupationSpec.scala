package com.malk.coc.concepts.occupations

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.occupations.Occupation
import com.malk.coc.helpers.SkillHelper

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

    describe(s"when ${occupationSkillPoints} and ${personalInterestPoints}") {
      val minCR = template.startCreditRating.value
      val maxCR = template.maximumCreditRating

      it(
        s"should have Credit Rating between ${minCR} and ${maxCR}"
      ) {
        val result = occupation.skills.filter(_.name == "Credit Rating").head

        result.value should (be >= minCR and be <= maxCR)
      }

      it(
        s"should have spent all occupation skills points"
      ) {
        occupation.remainingPoints shouldBe 0
      }

      it("should have all skills") {
        val available = SkillHelper
          .filteredSkills(template.excludedSkills)
          .map(_.name)

        val result = occupation.skills.map(_.name)

        result should contain theSameElementsAs available
      }
    }
  }
}
