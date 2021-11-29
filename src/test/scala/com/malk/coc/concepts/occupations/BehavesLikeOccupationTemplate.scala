package com.malk.coc.concepts.occupations

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.abstractions._

trait BehavesLikeOccupationTemplate extends AnyFunSpec with Matchers {
  def behavesLikeOccupationTemplate(
      occupationTemplate: OccupationTemplate,
      templateName: String,
      startCreditRating: CreditRating,
      maximumCreditRating: Int,
      result: TemplateSkillResult,
      templateSkillResult: TemplateSkillResult
  ): Unit = {
    it(s"should have name ${templateName}") {
      occupationTemplate.name shouldBe templateName
    }

    describe("getting template skills") {
      it(s"should have initial ${startCreditRating}") {
        occupationTemplate.startCreditRating shouldBe startCreditRating
      }

      it(s"should have maximum CreditRating ${maximumCreditRating}") {
        occupationTemplate.startCreditRating.maximum shouldBe maximumCreditRating
      }

      it(s"should have a list of fixed skills") {
        result.occupationFixedSkills should contain theSameElementsAs templateSkillResult.occupationFixedSkills
      }

      it(s"should have a list of optional skills") {
        result.occupationChooseSkills should contain theSameElementsAs templateSkillResult.occupationChooseSkills
      }

      it(s"should have a list of non trainable skills") {
        result.cannotSpendPointsSkills should contain theSameElementsAs templateSkillResult.cannotSpendPointsSkills
      }

      it(s"should have a list of excluded skills") {
        result.excludedSkills should contain theSameElementsAs templateSkillResult.excludedSkills
      }
    }
  }
}
