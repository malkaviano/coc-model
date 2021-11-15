package com.malk.coc.concepts.attributes

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

    describe(s"when ${luck} - 10") {
      val expected = Luck(30)

      it(s"should return ${expected}") {
        val result = luck - 10

        result shouldBe expected
      }
    }

    describe(s"when ${luck} + 6") {
      val expected = Luck(46)

      it(s"should return ${expected}") {
        val result = luck + 6

        result shouldBe expected
      }
    }
  }
}