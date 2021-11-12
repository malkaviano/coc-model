package com.malk.coc.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class DexteritySpec extends AnyFunSpec with Matchers {
  describe("The Dexterity") {
    val dex = Dexterity(80)

    it("should have name DEX") {
      dex.name shouldBe "DEX"
    }

    it("should have value 80") {
      dex.value shouldBe 80
    }

    describe(s"when ${dex} - 10") {
      val expected = Dexterity(70)

      it(s"should return ${expected}") {
        val result = dex - 10

        result shouldBe expected
      }
    }

    describe(s"when ${dex} + 6") {
      val expected = Dexterity(86)

      it(s"should return ${expected}") {
        val result = dex + 6

        result shouldBe expected
      }
    }
  }
}