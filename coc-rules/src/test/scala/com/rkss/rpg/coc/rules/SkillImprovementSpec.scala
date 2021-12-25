package com.rkss.rpg.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.props.TestingProps

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.props.fakes.FakeSkill
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.helpers.traits.DiceResult
import com.rkss.rpg.coc.props.fakes.FakeDiceResult

class SkillImprovementSpec extends AnyFunSpec with Matchers {
  describe("Improving a skill") {
    describe("Improvement check") {
      describe("when improvement check fails") {
        it("should have same improve value") {
          val result = skillImprovement(Seq(1), Seq(10), true)

          result shouldBe Option.empty[DiceResult]
        }
      }

      describe("when improvement check is equal or superior to 95") {
        it("should have higher improve value") {
          val result = skillImprovement(Seq(95), Seq(8), true)

          result shouldBe Some(FakeDiceResult(8))
        }
      }

      describe("when improvement check is superior to skill value") {
        it("should have higher improve value") {
          val result = skillImprovement(Seq(80), Seq(6), true)

          result shouldBe Some(FakeDiceResult(6))
        }
      }

      describe("when skill used check is false") {
        it("should have same improve value") {
          val result = skillImprovement(Seq(96), Seq(8), false)

          result shouldBe Option.empty[DiceResult]
        }
      }
    }

    // describe("verify if the skill was used with success") {
    //   describe("when skill was never used") {
    //     it(s"returns false") {
    //       val skill = ImprovableFakeSkill("SomeSkill", 10, 10, 5, 2)

    //       skill.usedWithSuccess shouldBe false
    //     }
    //   }

    //   describe("when skill was ticked") {
    //     val skill = ImprovableFakeSkill("SomeSkill", 10, 10, 5, 2)

    //     skill.tickUsedWithSuccess()

    //     skill.usedWithSuccess shouldBe true
    //   }
    // }
  }

  private def skillImprovement(
      rolledTest: Seq[Int],
      rolledImprovement: Seq[Int],
      skillUseSucceeded: Boolean
  ): Option[DiceResult] = {
    val hundredSidedDice = HundredSidedDice(
      TestingProps.fakeRng(rolledTest)
    )

    val tenSidedDice = TenSidedDice(
      TestingProps.fakeRng(rolledImprovement)
    )

    val improvableSkill = ImprovableFakeSkill("SomeSkill", 10, 10, 5, 2, skillUseSucceeded)

    improvableSkill.improvementCheck(hundredSidedDice, tenSidedDice)
  }
}

final case class ImprovableFakeSkill(
    override val name: String,
    override val baseValue: Int,
    override val regular: Int,
    override val hard: Int,
    override val extreme: Int,
    override val usedWithSuccess: Boolean
) extends FakeSkill(name, baseValue, regular, hard, extreme)
    with SkillImprovable
    with SkillImprovement {

  override def tickSuccessfullyUsed(): Unit = ???

  override def improvedValue: Int = ???

}
