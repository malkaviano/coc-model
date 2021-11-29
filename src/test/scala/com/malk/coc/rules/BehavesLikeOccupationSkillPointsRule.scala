package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.traits.OccupationSkillPoints
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.abstractions._

trait BehavesLikeOccupationSkillPointsRule extends AnyFunSpec with Matchers {
  def behavesLikeOccupationSkillPointsRule(
      rule: OccupationSkillPoints,
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance,
      expected: SkillPoints
  ): Unit = {
    describe(s"when ${body} ${brain} ${edu} ${app}") {
      it(s"should return ${expected}") {
        val result = rule.occupationSkillPoints(body, brain, edu, app)

        result shouldBe expected
      }
    }
  }
}
