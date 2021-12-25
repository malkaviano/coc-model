package com.rkss.rpg.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.props.TestingProps

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.props.fakes.FakeSkill
import com.rkss.rpg.coc.concepts.skill._

class SkillImprovementSpec extends AnyFunSpec with Matchers {
  describe("Improving a skill") {
    describe("Improvement check") {
      describe("when skill used check is true") {
        describe("when improvement check fails") {
          it("should have same improve value") {
            testSkillImprovement(Seq(1), Seq(10), ExtremeSuccess, 0, true)
          }
        }

        describe("when improvement check is equal or superior to 95") {
          it("should have higher improve value") {
            testSkillImprovement(Seq(95), Seq(8), HardSuccess, 8, true)
          }
        }

        describe("when improvement check is superior to skill value") {
          it("should have higher improve value") {
            testSkillImprovement(Seq(80), Seq(6), RegularSuccess, 6, true)
          }
        }
      }

      describe("when skill used check is false") {
        it("should have same improve value") {
          testSkillImprovement(Seq(96), Seq(8), Failure, 0, false)
        }
      }
    }

    describe("verify if the skill was used with success") {
      describe("when skill was never used") {
        it(s"returns false") {
          val skill = ImprovableFakeSkill("SomeSkill", 10, 10, 5, 2)

          skill.usedWithSuccess shouldBe false
        }
      }
    }
  }

  private def testSkillImprovement(
      rolledTest: Seq[Int],
      rolledImprovement: Seq[Int],
      skillRollResult: SkillRollResult,
      expected: Int,
      skillUseSucceeded: Boolean
  ): Unit = {
    val hundredSidedDice = HundredSidedDice(
      TestingProps.fakeRng(rolledTest)
    )

    val tenSidedDice = TenSidedDice(
      TestingProps.fakeRng(rolledImprovement)
    )

    val improvableSkill = ImprovableFakeSkill("SomeSkill", 10, 10, 5, 2)

    improvableSkill.improvementCheck(hundredSidedDice, tenSidedDice)

    improvableSkill.improvedValue shouldBe expected
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
