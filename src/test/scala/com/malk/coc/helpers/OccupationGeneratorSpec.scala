package com.malk.coc.helpers

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.helpers.SkillHelper
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints

class OccupationGeneratorSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.helpers.InvestigatorCharacteristics.implicits._
  import com.malk.coc.helpers.DiceHelper.implicits._
  import com.malk.coc.concepts.skills.languages.own.LanguageOwn
  import com.malk.coc.concepts.characteristics.Education
  import com.malk.coc.helpers.InvestigatorAttributes.implicits._

  InvestigatorOccupationTemplates.occupationTemplateNames.foreach(
    templateName => {
      describe(s"Generating random ${templateName}") {
        val implicitBody = body
        val implicitBrain = brain
        val implicitEdu = edu
        val implicitApp = app
        val implicitLanguage = language

        val template = InvestigatorOccupationTemplates.occupationTemplate(templateName)(
          implicitBody,
          implicitBrain,
          implicitEdu,
          implicitApp,
          implicitLanguage
        ).head

        val occupation = OccupationGenerator(template)

        val occupationSkillPoints =
          template.occupationSkillPoints

        val personalInterestPoints =
          InvestigatorSkillPoints(implicitBrain.intelligence.value * 2)

        describe(
          s"when ${occupationSkillPoints} and ${personalInterestPoints}"
        ) {
          val minCR = template.startCreditRating.value
          val maxCR = template.startCreditRating.maximum

          it(
            s"should have Credit Rating between ${minCR} and ${maxCR}"
          ) {
            val result =
              occupation.skills.filter(_.name == "Credit Rating").head

            result.value should (be >= minCR and be <= maxCR)
          }

          it(
            s"should have spent all occupation skills points"
          ) {
            occupation.remainingPoints shouldBe 0
          }

          val templateResult = template.templateSkills

          it("should have all skills") {
            val available = SkillHelper
              .filteredSkills(
                templateResult.excludedSkills + LanguageOwn(Education(0))(
                  implicitLanguage
                )
              )
              .map(_.name) + LanguageOwn(implicitEdu)(implicitLanguage).name

            val result = occupation.skills.map(_.name)

            result should contain theSameElementsAs available
          }
        }
      }
    }
  )
}
