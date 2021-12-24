package com.rkss.rpg.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.props.FakeSkill
import com.rkss.rpg.coc.props.TestingProps

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice._

class SkillDevelopmentSpec extends AnyFunSpec with Matchers {
  describe("Any developing Skill") {
    describe("verify if the skill was used with success") {
      describe("when skill was never used") {
        it(s"returns false") {
          val developingSkill = FakeSkill()

          developingSkill.succeeded shouldBe false
        }
      }

      Map(
        Failure -> false,
        Fumble -> false,
        RegularSuccess -> true,
        HardSuccess -> true,
        ExtremeSuccess -> true,
        CriticalSuccess -> true
      ).foreach {
        case (result, expected) => {
          describe(s"when skill roll result was $result") {
            it(s"returns $expected") {
              val developingSkill = FakeSkill()

              developingSkill.checkSuccess(result)

              developingSkill.succeeded shouldBe expected
            }
          }
        }
      }

      describe(s"when a skill roll result was a Success") {
        describe("when another skill roll was a Failure") {
          it(s"returns true") {
            val developingSkill = FakeSkill()

            developingSkill.checkSuccess(RegularSuccess)

            developingSkill.checkSuccess(Fumble)

            developingSkill.succeeded shouldBe true
          }
        }
      }
    }

    describe("when developing a skill") {
      describe("when skill used check is true") {
        describe("when improvement check fails") {
          it("returns same improve value") {
            testSkillDevelopment(Seq(1), Seq(10), ExtremeSuccess, 0)
          }
        }

        describe("when improvement check is equal or superior to 95") {
          it("returns higher improve value") {
            testSkillDevelopment(Seq(95), Seq(8), HardSuccess, 8)
          }
        }

        describe("when improvement check is superior to skill value") {
          it("returns higher improve value") {
            testSkillDevelopment(Seq(80), Seq(6), RegularSuccess, 6)
          }
        }
      }

      describe("when skill used check is false") {
        it("returns same improve value") {
          testSkillDevelopment(Seq(96), Seq(8), Failure, 0)
        }
      }
    }
  }

  private def testSkillDevelopment(
      rolledTest: Seq[Int],
      rolledImprovement: Seq[Int],
      skillRollResult: SkillRollResult,
      expected: Int
  ): Unit = {
    val hundredSidedDice = HundredSidedDice(
      TestingProps.fakeRng(rolledTest)
    )

    val tenSidedDice = TenSidedDice(
      TestingProps.fakeRng(rolledImprovement)
    )

    val developingSkill = FakeSkill()

    developingSkill.checkSuccess(skillRollResult)

    developingSkill.develop(hundredSidedDice, tenSidedDice)

    developingSkill.improved shouldBe expected
  }
}
