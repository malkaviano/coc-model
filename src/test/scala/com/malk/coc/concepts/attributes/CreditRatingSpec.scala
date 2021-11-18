package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class CreditRatingSpec extends AnyFunSpec with Matchers {
  describe("The Credit Rating") {
    val creditRating = CreditRating(21)

    it("should have name Credit Rating") {
      creditRating.name shouldBe "Credit Rating"
    }

    it("should have value 21") {
      creditRating.value shouldBe 21
    }

    describe(s"when ${creditRating} - 10") {
      val expected = CreditRating(11)

      it(s"should return ${expected}") {
        val result = creditRating - 10

        result shouldBe expected
      }
    }

    describe(s"when ${creditRating} + 6") {
      val expected = CreditRating(27)

      it(s"should return ${expected}") {
        val result = creditRating + 6

        result shouldBe expected
      }
    }
  }
}
