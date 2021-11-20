package com.malk.coc.helpers

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.helpers.SkillHelper
import com.malk.coc.concepts.occupations.TribeMemberTemplate
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints
import com.malk.coc.concepts.skills.languages.Arabic
import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.characteristics.Education

class OccupationGeneratorSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.helpers.InvestigatorCharacteristics.implicits._
  import com.malk.coc.helpers.DiceHelper.implicits._

  describe("Occupation") {
    val template = new TribeMemberTemplate
    val implicitBody = body
    val implicitBrain = brain
    val implicitEdu = edu
    val implicitApp = app

    // TODO: randomize this
    val language = Arabic

    val occupation = OccupationGenerator(
      template,
      implicitBody,
      implicitBrain,
      implicitEdu,
      implicitApp,
      language
    )

    it("should have name TRIBE MEMBER") {
      occupation.name shouldBe "TRIBE MEMBER"
    }

    val occupationSkillPoints =
      template.occupationSkillPoints(
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
          .map(_.name) + LanguageOwn(Education(0))(language).name

        val result = occupation.skills.map(_.name)

        result should contain theSameElementsAs available
      }
    }
  }
}
