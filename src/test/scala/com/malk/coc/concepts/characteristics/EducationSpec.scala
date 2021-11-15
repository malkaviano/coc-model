package com.malk.coc.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class EducationSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.traits.Characteristic.implicits._

  describe("The Education") {
    val edu = Education(69)

    it("should have name EDU") {
      edu.name shouldBe "EDU"
    }

    it("should have value 69") {
      edu.value shouldBe 69
    }

    describe(s"when ${edu} - 10") {
      val expected = Education(59)

      it(s"should return ${expected}") {
        val result = edu - 10

        result shouldBe expected
      }
    }

    describe(s"when ${edu} + 6") {
      val expected = Education(75)

      it(s"should return ${expected}") {
        val result = edu + 6

        result shouldBe expected
      }
    }

    describe(s"when ${edu} + ${edu}") {
      val expected = Education(138)

      it(s"should be ${expected}") {
        val result = edu + edu

        result shouldBe expected
      }
    }

    describe(s"when ${edu} - ${edu}") {
      val expected = Education(0)

      it(s"should be ${expected}") {
        val result = edu - edu

        result shouldBe expected
      }
    }
  }
}