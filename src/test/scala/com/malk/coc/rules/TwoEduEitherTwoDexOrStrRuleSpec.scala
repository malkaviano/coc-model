package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints
import com.malk.coc.traits.OccupationSkillPointsRule
import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.concepts.characteristics.Dexterity

trait BehavesLikeOccupationSkillPointsRule extends AnyFunSpec with Matchers {
  def behavesLikeOccupationSkillPointsRule(
      rule: OccupationSkillPointsRule,
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance,
      expected: InvestigatorSkillPoints
  ): Unit = {
    describe(s"when ${body} ${brain} ${edu} ${app}") {
      it(s"should return ${expected}") {
        val result = rule.occupationSkillPoints(body, brain, edu, app)

        result shouldBe expected
      }
    }
  }
}
class TwoEduEitherTwoDexOrStrRuleSpec
    extends AnyFunSpec
    with BehavesLikeOccupationSkillPointsRule {
  describe("TwoEduEitherTwoStrOrDexRule") {
    import  com.malk.coc.helpers.InvestigatorCharacteristics.implicits._
    import com.malk.coc.helpers.DiceHelper.implicits._

    val edu = Education(60)

    val rule = new TwoEduEitherTwoDexOrStrRule

    it("should have name TwoEduEitherTwoStrOrDexRule") {
      rule.name shouldBe "TwoEduEitherTwoStrOrDexRule"
    }

    describe("when Strength and Dexterity are equal") {
      val body = Body(Strength(50), con, Dexterity(50), siz)

      behavesLikeOccupationSkillPointsRule(
        rule,
        body,
        brain,
        edu,
        app,
        InvestigatorSkillPoints(220)
      )
    }

    describe("when Strength is greater than Dexterity") {
      val body = Body(Strength(60), con, Dexterity(50), siz)

      behavesLikeOccupationSkillPointsRule(
        rule,
        body,
        brain,
        edu,
        app,
        InvestigatorSkillPoints(240)
      )
    }

    describe("when Strength is less than Dexterity") {
      val body = Body(Strength(40), con, Dexterity(70), siz)

      val rule = new TwoEduEitherTwoDexOrStrRule

      behavesLikeOccupationSkillPointsRule(
        rule,
        body,
        brain,
        edu,
        app,
        InvestigatorSkillPoints(260)
      )
    }
  }
}
