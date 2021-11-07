package com.malk.coc.v7.concepts.characteristics

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
  }
}