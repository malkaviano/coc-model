package com.rkss.rpg.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.skill.roll._

class BaseSkillBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Basic skill behavior") {
    val basicSkill = new BaseSkillBehavior {
      override def name: String = "Some Skill"

      override def baseValue: Int = 40
    }

    it("should have regular value") {
      basicSkill.value() shouldBe 40
    }

    it("should have hard value") {
      basicSkill.value(HardDifficulty) shouldBe 20
    }

    it("should have extreme value") {
      basicSkill.value(ExtremeDifficulty) shouldBe 8
    }
  }
}
