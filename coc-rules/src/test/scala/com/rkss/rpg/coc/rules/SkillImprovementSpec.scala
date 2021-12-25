package com.rkss.rpg.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.props.TestingProps

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.props.fakes.FakeSkill
import com.rkss.rpg.coc.concepts.skill._

class SkillImprovementSpec extends AnyFunSpec with Matchers {
  describe("Improving a skill") {
    describe("Improvement check") {
      describe("when skill used check is true") {
        describe("when improvement check fails") {
          val skill = skillImprovement(Seq(1), Seq(10), true)

          it("should have same improve value") {
            skill.improvedValue shouldBe 0
          }

          it should behave like checkUsedWithSuccess(skill, false)
        }

        describe("when improvement check is equal or superior to 95") {
          val skill = skillImprovement(Seq(95), Seq(8), true)

          it("should have higher improve value") {
            skill.improvedValue shouldBe 8
          }

          it should behave like checkUsedWithSuccess(skill, false)
        }

        describe("when improvement check is superior to skill value") {
          val skill = skillImprovement(Seq(80), Seq(6), true)

          it("should have higher improve value") {
            skill.improvedValue shouldBe 6
          }

          it should behave like checkUsedWithSuccess(skill, false)
        }
      }

      describe("when skill used check is false") {
        val skill = skillImprovement(Seq(96), Seq(8), false)

        it("should have same improve value") {
          skill.improvedValue shouldBe 0
        }

        it should behave like checkUsedWithSuccess(skill, false)
      }
    }

    describe("verify if the skill was used with success") {
      describe("when skill was never used") {
        it(s"returns false") {
          val skill = ImprovableFakeSkill("SomeSkill", 10, 10, 5, 2)

          skill.usedWithSuccess shouldBe false
        }
      }

      describe("when skill was ticked") {
        val skill = ImprovableFakeSkill("SomeSkill", 10, 10, 5, 2)

        skill.tickUsedWithSuccess()

        skill.usedWithSuccess shouldBe true
      }
    }
  }

  private def skillImprovement(
      rolledTest: Seq[Int],
      rolledImprovement: Seq[Int],
      skillUseSucceeded: Boolean
  ): SkillImprovement = {
    val hundredSidedDice = HundredSidedDice(
      TestingProps.fakeRng(rolledTest)
    )

    val tenSidedDice = TenSidedDice(
      TestingProps.fakeRng(rolledImprovement)
    )

    val improvableSkill = ImprovableFakeSkill("SomeSkill", 10, 10, 5, 2)

    if (skillUseSucceeded) improvableSkill.tickUsedWithSuccess()

    improvableSkill.improvementCheck(hundredSidedDice, tenSidedDice)

    improvableSkill
  }

  private def checkUsedWithSuccess(skill: SkillImprovement, expected: Boolean): Unit = {
    describe("After skill improvement check") {
      describe("usedWithSuccess") {
        it("return false") {
          skill.usedWithSuccess shouldBe expected
        }
      }
    }
  }
}

final case class ImprovableFakeSkill(
    override val name: String,
    override val baseValue: Int,
    override val regular: Int,
    override val hard: Int,
    override val extreme: Int
) extends FakeSkill(name, baseValue, regular, hard, extreme)
    with SkillImprovable
    with SkillImprovement
