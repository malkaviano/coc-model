package com.malk.coc.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class StrengthSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.traits.Characteristic.implicits._

  describe("The Strength") {
    val str = Strength(60)

    it("should have name STR") {
      str.name shouldBe "STR"
    }

    it("should have value 60") {
      str.value shouldBe 60
    }

    describe(s"when ${str} - 10") {
      val expected = Strength(50)

      it(s"should return ${expected}") {
        val result = str - 10

        result shouldBe expected
      }
    }

    describe(s"when ${str} + 6") {
      val expected = Strength(66)

      it(s"should return ${expected}") {
        val result = str + 6

        result shouldBe expected
      }
    }

    describe(s"when ${str} + ${str}") {
      val expected = Strength(120)

      it(s"should be ${expected}") {
        val result = str + str

        result shouldBe expected
      }
    }

    describe(s"when ${str} - ${str}") {
      val expected = Strength(0)

      it(s"should be ${expected}") {
        val result = str - str

        result shouldBe expected
      }
    }
  }
}
