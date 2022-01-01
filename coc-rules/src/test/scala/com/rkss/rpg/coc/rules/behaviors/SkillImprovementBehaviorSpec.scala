package com.rkss.rpg.coc.rules.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.rules.testing.fakes.FakeSkillImprovable
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.rules.testing.TestingProps
import com.rkss.rpg.coc.concepts.skill.improvement.SkillImproved
import com.rkss.rpg.helpers.traits.DiceResult

final class SkillImprovementBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Skill improvement behavior") {
    val skill = FakeSkillImprovable("fake", 15, 20, 10)

    val hundredSidedDice = HundredSidedDice(
      TestingProps.fakeRng(Seq(95))
    )

    val tenSidedDice = TenSidedDice(
      TestingProps.fakeRng(Seq(9))
    )

    val expected = SkillImproved(skill, 0, Option.empty[DiceResult], false)

    it(s"return $expected") {
      val result = skill.improvementCheck(hundredSidedDice, tenSidedDice)

      result shouldBe expected
    }
  }
}
