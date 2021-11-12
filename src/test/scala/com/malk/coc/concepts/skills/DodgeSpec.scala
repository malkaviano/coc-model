package com.malk.coc.concepts.skills

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.Dexterity

class DodgeSpec extends AnyFunSpec with Matchers {
  describe("The Dodge skill") {
    val dex = Dexterity(67)

    val skill = Dodge(dex)(5)

    it("should have name Dodge") {
      skill.name shouldBe "Dodge"
    }

    it("should have base equal 33") {
      skill.base shouldBe 33
    }

    it("should have value equal 38") {
      skill.value shouldBe 38
    }

    it("should have canPush equal false") {
      skill.canPush shouldBe false
    }
  }
}
