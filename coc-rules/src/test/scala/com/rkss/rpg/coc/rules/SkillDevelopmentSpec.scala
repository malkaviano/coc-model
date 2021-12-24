package com.rkss.rpg.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.props.TestingProps

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.props.fakes.FakeSkill
import com.rkss.rpg.coc.concepts.skill.SkillUsedCheck

class SkillDevelopmentSpec extends AnyFunSpec with Matchers {
  describe("Developing a skill") {
    describe("when skill used check is true") {
      describe("when improvement check fails") {
        it("returns same improve value") {
          testSkillDevelopment(Seq(1), Seq(10), ExtremeSuccess, 0, true)
        }
      }

      describe("when improvement check is equal or superior to 95") {
        it("returns higher improve value") {
          testSkillDevelopment(Seq(95), Seq(8), HardSuccess, 8, true)
        }
      }

      describe("when improvement check is superior to skill value") {
        it("returns higher improve value") {
          testSkillDevelopment(Seq(80), Seq(6), RegularSuccess, 6, true)
        }
      }
    }

    describe("when skill used check is false") {
      it("returns same improve value") {
        testSkillDevelopment(Seq(96), Seq(8), Failure, 0, false)
      }
    }
  }

  private def testSkillDevelopment(
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

    val developingSkill = new FakeSkill("SomeSkill", 10, 10, 5, 2)
      with SkillUsedCheck
      with SkillDevelopment {
      override def succeeded: Boolean = skillUseSucceeded
    }

    developingSkill.develop(hundredSidedDice, tenSidedDice)
  }
}
