package com.malk.coc.rules

import com.malk.coc.abstractions._
import com.malk.coc.concepts.characteristics._

class TwoEduEitherTwoDexOrStrRuleSpec
    extends BehavesLikeOccupationSkillPointsRule {
  describe("TwoEduEitherTwoStrOrDexRule") {
    import  com.malk.coc.generators.InvestigatorCharacteristics.implicits._
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
        SkillPoints(220)
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
        SkillPoints(240)
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
        SkillPoints(260)
      )
    }
  }
}
