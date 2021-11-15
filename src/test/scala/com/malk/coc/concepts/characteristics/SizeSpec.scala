package com.malk.coc.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class SizeSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.helpers.CharacteristicModifications.implicits._

  describe("The Size") {
    val siz = Size(70)

    it("should have name SIZ") {
      siz.name shouldBe "SIZ"
    }

    it("should have value 70") {
      siz.value shouldBe 70
    }

    describe(s"when ${siz} - 10") {
      val expected = Size(60)

      it(s"should return ${expected}") {
        val result = siz - 10

        result shouldBe expected
      }
    }

    describe(s"when ${siz} + 6") {
      val expected = Size(76)

      it(s"should return ${expected}") {
        val result = siz + 6

        result shouldBe expected
      }
    }
  }
}
