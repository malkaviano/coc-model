package com.rkss.rpg.coc.rules.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.props.TestingProps

class BaseSkillBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Basic skill behavior") {
    val skill = new BaseSkillBehavior {
      override def name: String = "Some Skill"

      override def baseValue: Int = 40
    }

    it("should have regular value") {
      skill.value() shouldBe 40
    }

    it("should have hard value") {
      skill.value(HardDifficulty) shouldBe 20
    }

    it("should have extreme value") {
      skill.value(ExtremeDifficulty) shouldBe 8
    }

    describe("Skill roll") {
      describe("when making a skill roll") {
        val hundredSidedDice =
          HundredSidedDice(TestingProps.fakeRng(Seq(20)))

        it("return a SkillRollResult") {
          val result = skill.roll()(hundredSidedDice)

          result shouldBe HardSuccess
        }
      }
    }
  }
}
