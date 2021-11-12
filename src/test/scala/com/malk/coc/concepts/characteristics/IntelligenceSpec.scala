package com.malk.coc.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class IntelligenceSpec extends AnyFunSpec with Matchers {
  describe("The Intelligence") {
    val int = Intelligence(48)

    it("should have name INT") {
      int.name shouldBe "INT"
    }

    it("should have value 48") {
      int.value shouldBe 48
    }

    describe(s"when ${int} - 10") {
      val expected = Intelligence(38)

      it(s"should return ${expected}") {
        val result = int - 10

        result shouldBe expected
      }
    }

    describe(s"when ${int} + 6") {
      val expected = Intelligence(54)

      it(s"should return ${expected}") {
        val result = int + 6

        result shouldBe expected
      }
    }
  }
}