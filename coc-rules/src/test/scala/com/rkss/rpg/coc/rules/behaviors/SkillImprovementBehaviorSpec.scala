package com.rkss.rpg.coc.rules.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.rules.testing.fakes.FakeSkillImprovable
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.rules.testing.TestingProps
import com.rkss.rpg.coc.concepts.skill.improvement.SkillImproved
import com.rkss.rpg.helpers.traits.DiceResult
import com.rkss.rpg.coc.rules.testing.fakes.FakeDiceResult

final class SkillImprovementBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Skill improvement behavior") {
    describe("when skill used with success was false") {
      val skill = FakeSkillImprovable("fake", 15, 20, 10)

      it should behave like improvementCheck(
        skill,
        SkillImproved(skill, 0, Option.empty[DiceResult], false),
        Seq(95),
        Seq(9)
      )

      it should behave like checkUsedWithSuccess(skill)

      it should behave like improvedValue(skill, 0)
    }

    describe("when skill used with success was true") {
      val skill = FakeSkillImprovable("fake", 15, 20, 10)

      skill.checkUsedWithSuccess()

      it should behave like improvementCheck(
        skill,
        SkillImproved(skill, 9, Option(FakeDiceResult(95)), false),
        Seq(95),
        Seq(9)
      )

      it should behave like checkUsedWithSuccess(skill)

      it should behave like improvedValue(skill, 9)
    }
  }

  private def improvementCheck(
      skill: FakeSkillImprovable,
      expected: SkillImproved,
      rolled: Seq[Int],
      improved: Seq[Int]
  ): Unit = {
    val hundredSidedDice = HundredSidedDice(
      TestingProps.fakeRng(rolled)
    )

    val tenSidedDice = TenSidedDice(
      TestingProps.fakeRng(improved)
    )

    it(s"return $expected") {
      val result = skill.improvementCheck(hundredSidedDice, tenSidedDice)

      result shouldBe expected
    }
  }

  private def checkUsedWithSuccess(skill: FakeSkillImprovable): Unit = {
    describe("Used with success") {
      it("returns false") {
        skill.successCheck shouldBe false
      }
    }
  }

  private def improvedValue(
      skill: FakeSkillImprovable,
      expected: Int
  ): Unit = {
    describe("Improved value") {
      it(s"returns $expected") {
        skill.improvedValue shouldBe expected
      }
    }
  }
}
