package com.malk.coc.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class PowerSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.traits.Characteristic.implicits._

  describe("The Power") {
    val pow = Power(70)

    it("should have name PWR") {
      pow.name shouldBe "PWR"
    }

    it("should have value 70") {
      pow.value shouldBe 70
    }

    describe(s"when ${pow} - 10") {
      val expected = Power(60)

      it(s"should return ${expected}") {
        val result = pow - 10

        result shouldBe expected
      }
    }

    describe(s"when ${pow} + 6") {
      val expected = Power(76)

      it(s"should return ${expected}") {
        val result = pow + 6

        result shouldBe expected
      }
    }

    describe(s"when ${pow} + ${pow}") {
      val expected = Power(140)

      it(s"should be ${expected}") {
        val result = pow + pow

        result shouldBe expected
      }
    }

    describe(s"when ${pow} - ${pow}") {
      val expected = Power(0)

      it(s"should be ${expected}") {
        val result = pow - pow

        result shouldBe expected
      }
    }
  }
}
