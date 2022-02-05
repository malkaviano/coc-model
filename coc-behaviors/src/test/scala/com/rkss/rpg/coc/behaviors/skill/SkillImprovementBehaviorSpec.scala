package com.rkss.rpg.coc.behaviors.skill

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.behaviors.testing.fakes.FakeSkillImprovable
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.behaviors.testing.TestingProps
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts._

final class SkillImprovementBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Skill improvement behavior") {
    describe("when skill used with success was false") {
      val skill = FakeSkillImprovable(Pharmacy, 15, 20, 10)

      it should behave like improvementCheck(
        skill,
        SkillImproved(
          Pharmacy,
          45,
          0,
          Option.empty[RollDiceResult],
          false
        ),
        Seq(95),
        Seq(9)
      )

      it should behave like markUsedWithSuccess(skill)

      it should behave like improvedValue(skill, 0)
    }

    describe("when skill used with success was true") {
      val skill = FakeSkillImprovable(Biology, 15, 20, 10)

      skill.markUsedWithSuccess()

      it should behave like improvementCheck(
        skill,
        SkillImproved(Biology, 45, 9, Option(RollDiceResult(95)), false),
        Seq(95),
        Seq(9)
      )

      it should behave like markUsedWithSuccess(skill)

      it should behave like improvedValue(skill, 9)
    }
  }

  private def improvementCheck[A <: ImprovableSkillName](
      skill: FakeSkillImprovable[A],
      expected: SkillImproved[A],
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

  private def markUsedWithSuccess[A <: ImprovableSkillName](
      skill: FakeSkillImprovable[A]
  ): Unit = {
    describe("Used with success") {
      it("returns false") {
        skill.wasSuccessfullyUsed shouldBe false
      }
    }
  }

  private def improvedValue[A <: ImprovableSkillName](
      skill: FakeSkillImprovable[A],
      expected: Int
  ): Unit = {
    describe("Improved value") {
      it(s"returns $expected") {
        skill.improvement shouldBe expected
      }
    }
  }
}
