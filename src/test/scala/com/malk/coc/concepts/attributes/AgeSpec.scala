package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class AgeSpec extends AnyFunSpec with Matchers {
  describe("The Age") {
    val age = Age(21)

    it("should have name Age") {
      age.name shouldBe "Age"
    }

    it("should have value 21") {
      age.value shouldBe 21
    }

    describe(s"when ${age} - 10") {
      val expected = Age(11)

      it(s"should return ${expected}") {
        val result = age - 10

        result shouldBe expected
      }
    }

    describe(s"when ${age} + 6") {
      val expected = Age(27)

      it(s"should return ${expected}") {
        val result = age + 6

        result shouldBe expected
      }
    }
  }
}