package com.malk.coc.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class ConstitutionSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.helpers.CharacteristicModifications.implicits._

  describe("The Constitution") {
    val con = Constitution(55)

    it("should have name CON") {
      con.name shouldBe "CON"
    }

    it("should have value 55") {
      con.value shouldBe 55
    }

    describe(s"when ${con} - 10") {
      val expected = Constitution(45)

      it(s"should return ${expected}") {
        val result = con - 10

        result shouldBe expected
      }
    }

    describe(s"when ${con} + 6") {
      val expected = Constitution(61)

      it(s"should return ${expected}") {
        val result = con + 6

        result shouldBe expected
      }
    }
  }
}