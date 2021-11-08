package com.malk.coc.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class LuckSpec extends AnyFunSpec with Matchers {
  describe("The Luck") {
    val luck = Luck(40)

    it("should have name Luck") {
      luck.name shouldBe "Luck"
    }

    it("should have value 40") {
      luck.value shouldBe 40
    }
  }
}