package com.malk.coc.concepts.occupations

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.traits.Skill

trait BehavesLikeOccupationTemplate extends AnyFunSpec with Matchers {
  def behavesLikeOccupationTemplate(
      occupationTemplate: OccupationTemplate,
      templateName: String,
      startCreditRating: CreditRating,
      maximumCreditRating: Int,
      result: (Set[Skill], Set[(Int, Set[Skill])],Set[Skill],Set[Skill]),
      fixedSkills: Set[Skill],
      optionalSkills: Set[(Int, Set[Skill])],
      personalSkills: Set[Skill],
      nonTrainableSkills: Set[Skill]
  ): Unit = {
    it(s"should have name ${templateName}") {
      occupationTemplate.name shouldBe templateName
    }

    describe("getting template skills") {
      it(s"should have initial ${startCreditRating}") {
        occupationTemplate.startCreditRating.value shouldBe startCreditRating.value
      }

      it(s"should have maximum ${maximumCreditRating}") {
        occupationTemplate.maximumCreditRating shouldBe maximumCreditRating
      }

      it(s"should have a list of fixed skills") {
        result._1 should contain theSameElementsAs fixedSkills
      }

      it(s"should have a list of optional skills") {
        result._2 should contain theSameElementsAs optionalSkills
      }

      it(s"should have a list of personal skills") {
        result._3 should contain theSameElementsAs personalSkills
      }

      it(s"should have a list of non trainable skills") {
        result._4 should contain theSameElementsAs nonTrainableSkills
      }
    }
  }
}
