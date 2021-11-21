package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.traits.OccupationSkillPointsRule
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints

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
