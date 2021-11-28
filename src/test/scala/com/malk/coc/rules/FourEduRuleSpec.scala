package com.malk.coc.rules

import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints

class FourEduRuleSpec extends BehavesLikeOccupationSkillPointsRule {
  describe("FourEduRule") {
    import com.malk.coc.generators.InvestigatorCharacteristics.implicits._
    import com.malk.coc.helpers.DiceHelper.implicits._

    val edu = Education(60)

    val rule = new FourEduRule

    it("should have name FourEduRule") {
      rule.name shouldBe "FourEduRule"
    }

    behavesLikeOccupationSkillPointsRule(
      rule,
      body,
      brain,
      edu,
      app,
      InvestigatorSkillPoints(240)
    )
  }
}
