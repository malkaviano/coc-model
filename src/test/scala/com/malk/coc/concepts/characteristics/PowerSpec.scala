package com.malk.coc.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class PowerSpec extends AnyFunSpec with Matchers {
  describe("The Power") {
    val pow = Power(70)

    it("should have name PWR") {
      pow.name shouldBe "PWR"
    }

    it("should have value 70") {
      pow.value shouldBe 70
    }
  }
}