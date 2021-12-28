package com.rkss.rpg.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.helpers.traits.DiceResult
import com.rkss.rpg.coc.rules.testing._
import com.rkss.rpg.coc.rules.testing.fakes._

class SkillImprovementSpec extends AnyFunSpec with Matchers {
  describe("Improving a skill") {
    describe("Improvement check") {
      describe("when improvement check fails") {
        it("should have same improve value") {
          val result = skillImprovement(Seq(1), Seq(10))

          result shouldBe Option.empty[DiceResult]
        }
      }

      describe("when improvement check is equal or superior to 95") {
        it("should have higher improve value") {
          val result = skillImprovement(Seq(95), Seq(8))

          result shouldBe Some(FakeDiceResult(8))
        }
      }

      describe("when improvement check is superior to skill value") {
        it("should have higher improve value") {
          val result = skillImprovement(Seq(80), Seq(6))

          result shouldBe Some(FakeDiceResult(6))
        }
      }
    }
  }

  private def skillImprovement(
      rolledTest: Seq[Int],
      rolledImprovement: Seq[Int]
  ): Option[DiceResult] = {
    val hundredSidedDice = HundredSidedDice(
      TestingProps.fakeRng(rolledTest)
    )

    val tenSidedDice = TenSidedDice(
      TestingProps.fakeRng(rolledImprovement)
    )

    FakeSkillImprovement("fake", 50, 50, 25, 10).improvementCheck(
      hundredSidedDice,
      tenSidedDice
    )
  }
}

final case class FakeSkillImprovement(
    override val name: String,
    override val baseValue: Int,
    override val regular: Int,
    override val hard: Int,
    override val extreme: Int
) extends FakeSkill(name, baseValue, regular, hard, extreme)
    with SkillImprovement
