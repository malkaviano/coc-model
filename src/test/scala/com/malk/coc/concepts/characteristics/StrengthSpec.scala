package com.malk.coc.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class StrengthSpec extends AnyFunSpec with Matchers {
  describe("The Strength") {
    val str = Strength(60)

    it("should have name STR") {
      str.name shouldBe "STR"
    }

    it("should have value 60") {
      str.value shouldBe 60
    }
  }
}