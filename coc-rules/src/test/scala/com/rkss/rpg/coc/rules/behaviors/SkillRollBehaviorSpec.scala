package com.rkss.rpg.coc.rules.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.rules.testing.fakes._
import com.rkss.rpg.coc.rules.testing._

final class SkillRollBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Skill roll behavior") {
    val skill = new FakeSkill("fake", 40)

    describe("Skill roll") {
      describe("when making a skill roll") {
        val hundredSidedDice =
          HundredSidedDice(TestingProps.fakeRng(Seq(20)))

        val expected = SkillRolled(
          skill,
          RegularDifficulty,
          BonusDice(0),
          PenaltyDice(0),
          HardSuccess,
          SkillRollDiceResult(20)
        )

        it("return a SkillRollResult") {
          val result = skill.roll()(hundredSidedDice)

          result shouldBe expected
        }
      }
    }
  }
}
