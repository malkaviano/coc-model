package com.rkss.rpg.coc.behaviors.executors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.behaviors.testing.fakes._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.behaviors.testing.TestingProps
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.behaviors.results._

final class ImprovementCheckExecutorSpec extends AnyFunSpec with Matchers {
  describe("Improvement Check") {
    describe("when skill fails the improvement check") {
      val skill = FakeSkillWithSuccessCheck(Anthropology, 30)

      val expected =
        ImprovementChecked(RollDiceResult(10), 0)

      it should behave like improvementCheck(skill, Seq(10), Seq(8), expected)
    }

    describe("when skill succeeds the improvement check") {
      val skill = FakeSkillWithSuccessCheck(Handgun, 30)

      val expected =
        ImprovementChecked(RollDiceResult(90), 8)

      it should behave like improvementCheck(skill, Seq(90), Seq(8), expected)

      describe("when skill value is 101") {
        val skill = FakeSkillWithSuccessCheck(Axe, 30, 50, 21)

        val expected =
          ImprovementChecked(RollDiceResult(98), 6)

        it should behave like improvementCheck(skill, Seq(98), Seq(6), expected)
      }

      describe("when skill reaches 90%") {
        val skill = FakeSkillWithSuccessCheck(Brawl, 30, 50, 6)

        val expected =
          ImprovementChecked(RollDiceResult(100), 4)

        it should behave like improvementCheck(
          skill,
          Seq(100),
          Seq(4),
          expected
        )
      }
    }
  }

  private def improvementCheck[A <: ImprovableSkillName](
      skill: FakeSkillWithSuccessCheck,
      check: Seq[Int],
      improved: Seq[Int],
      expected: ImprovementChecked
  ) = {
    val hundredSidedDice = HundredSidedDice(
      TestingProps.fakeRng(check)
    )

    val tenSidedDice = TenSidedDice(
      TestingProps.fakeRng(improved)
    )

    it(s"return $expected") {
      val skillImprovementCheck = ImprovementCheckExecutor.instance

      val result = skillImprovementCheck.improvementCheck(skill)(
        hundredSidedDice,
        tenSidedDice
      )

      result shouldBe expected
    }
  }
}
