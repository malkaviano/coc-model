package com.malk.coc.rules

import com.malk.coc.abstractions.Brain
import com.malk.coc.concepts.characteristics._
import com.malk.coc.abstractions._

class TwoEduEitherTwoAppOrPowRuleSpec extends BehavesLikeOccupationSkillPointsRule {
  describe("TwoEduEitherTwoAppOrPowRule") {
    import  com.malk.coc.generators.InvestigatorCharacteristics.implicits._
    import com.malk.coc.helpers.DiceHelper.implicits._

    val edu = Education(60)

    val rule = new TwoEduEitherTwoAppOrPowRule

    it("should have name TwoEduEitherTwoAppOrPowRule") {
      rule.name shouldBe "TwoEduEitherTwoAppOrPowRule"
    }

    describe("when Appearance and Power are equal") {
      val brain = Brain(int, Power(50))
      val app = Appearance(50)

      behavesLikeOccupationSkillPointsRule(
        rule,
        body,
        brain,
        edu,
        app,
        SkillPoints(220)
      )
    }

    describe("when Appearance is greater than Power") {
      val brain = Brain(int, Power(50))
      val app = Appearance(60)

      behavesLikeOccupationSkillPointsRule(
        rule,
        body,
        brain,
        edu,
        app,
        SkillPoints(240)
      )
    }

    describe("when Appearance is less than Power") {
      val brain = Brain(int, Power(70))
      val app = Appearance(60)
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
