package com.malk.coc.v7.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class PowerSpec extends AnyFunSpec with Matchers {
  describe("The Power") {
    val pow = Power(70)

    it("should have name Power") {
      pow.name shouldBe "PWR"
    }

    it("should have value 70") {
      pow.value shouldBe 70
    }
  }
}