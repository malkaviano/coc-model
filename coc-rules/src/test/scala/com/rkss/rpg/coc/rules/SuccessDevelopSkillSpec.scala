package com.rkss.rpg.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.skill.roll._

class SuccessDevelopSkillSpec extends AnyFunSpec with Matchers {
  describe("On success use developing skill behavior") {
    val basicSkill = new SuccessDevelopSkill {
      override def name: String = "Some Skill"

      override def baseValue: Int = 40
    }

    it("should have regular value") {
      basicSkill.value() shouldBe 50
    }

    it("should have hard value") {
      basicSkill.value(HardDifficulty) shouldBe 25
    }

    it("should have extreme value") {
      basicSkill.value(ExtremeDifficulty) shouldBe 10
    }
  }
}
