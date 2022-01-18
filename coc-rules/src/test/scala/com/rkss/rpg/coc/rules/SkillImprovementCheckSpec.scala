package com.rkss.rpg.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.rules.testing.fakes._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.rules.testing.TestingProps
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDiceResult
import com.rkss.rpg.coc.concepts.skill._

final class SkillImprovementCheckSpec extends AnyFunSpec with Matchers {
  describe("Skill Improvement Check") {
    describe("when skill fails the improvement check") {
      val skill = FakeSkillWithSuccessCheck(Anthropology, 30)

      val expected =
        SkillImproved(skill, 0, Option(SkillRollDiceResult(10)), false)

      it should behave like improvementCheck(skill, Seq(10), Seq(8), expected)
    }

    describe("when skill succeeds the improvement check") {
      val skill = FakeSkillWithSuccessCheck(Handgun, 30)

      val expected =
        SkillImproved(skill, 8, Option(SkillRollDiceResult(90)), false)

      it should behave like improvementCheck(skill, Seq(90), Seq(8), expected)

      describe("when skill value is 101") {
        val skill = FakeSkillWithSuccessCheck(Axe, 30, 50, 21)

        val expected =
          SkillImproved(skill, 6, Option(SkillRollDiceResult(98)), false)

        it should behave like improvementCheck(skill, Seq(98), Seq(6), expected)
      }

      describe("when skill reaches 90%") {
        val skill = FakeSkillWithSuccessCheck(Brawl, 30, 50, 6)

        val expected =
          SkillImproved(skill, 4, Option(SkillRollDiceResult(100)), true)

        it should behave like improvementCheck(skill, Seq(100), Seq(4), expected)
      }
    }
  }

  private def improvementCheck(
      skill: FakeSkillWithSuccessCheck,
      check: Seq[Int],
      improved: Seq[Int],
      expected: SkillImproved
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
