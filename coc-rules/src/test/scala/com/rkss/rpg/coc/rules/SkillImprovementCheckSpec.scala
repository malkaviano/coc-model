package com.rkss.rpg.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.rules.testing.fakes._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.rules.testing.TestingProps
import com.rkss.rpg.coc.concepts.skill.SkillImprovementResult
import com.rkss.rpg.helpers.traits.DiceResult

final class SkillImprovementCheckSpec extends AnyFunSpec with Matchers {
  describe("Skill Improvement Check") {
    describe("when skill has no success check") {
      val skill = FakeSkillWithSuccessCheck("fake", 30)

      val expected =
        SkillImprovementResult(skill, 0, Option.empty[DiceResult], false)

      it should behave like improvementCheck(skill, Seq(10), Seq(8), expected)
    }

    describe("when skill fails the improvement check") {
      val skill = FakeSkillWithSuccessCheck("fake", 30, successCheck = true)

      val expected =
        SkillImprovementResult(skill, 0, Option.empty[DiceResult], false)

      it should behave like improvementCheck(skill, Seq(10), Seq(8), expected)
    }

    describe("when skill succeeds the improvement check") {
      val skill = FakeSkillWithSuccessCheck("fake", 30, successCheck = true)

      val expected =
        SkillImprovementResult(skill, 8, Option(FakeDiceResult(8)), false)

      it should behave like improvementCheck(skill, Seq(90), Seq(8), expected)

      describe("when skill value is 101") {
        val skill = FakeSkillWithSuccessCheck("fake", 30, 50, 21, successCheck = true)

        val expected =
          SkillImprovementResult(skill, 6, Option(FakeDiceResult(6)), false)

        it should behave like improvementCheck(skill, Seq(98), Seq(6), expected)
      }

      describe("when skill reaches 90%") {
        val skill = FakeSkillWithSuccessCheck("fake", 30, 50, 6, successCheck = true)

        val expected =
          SkillImprovementResult(skill, 4, Option(FakeDiceResult(4)), true)

        it should behave like improvementCheck(skill, Seq(100), Seq(4), expected)
      }
    }
  }

  private def improvementCheck(
      skill: FakeSkillWithSuccessCheck,
      check: Seq[Int],
      improved: Seq[Int],
      expected: SkillImprovementResult
  ) = {
    val hundredSidedDice = HundredSidedDice(
      TestingProps.fakeRng(check)
    )

    val tenSidedDice = TenSidedDice(
      TestingProps.fakeRng(improved)
    )

    it(s"return $expected") {
      val skillImprovementCheck = SkillImprovementCheck.instance

      val result = skillImprovementCheck.improvementCheck(skill)(
        hundredSidedDice,
        tenSidedDice
      )

      result shouldBe expected
    }
  }
}
