package com.malk.coc.v7.concepts.characteristics

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
  }
}