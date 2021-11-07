package com.malk.coc.v7.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class SizeSpec extends AnyFunSpec with Matchers {
  describe("The Size") {
    val siz = Size(70)

    it("should have name SIZ") {
      siz.name shouldBe "SIZ"
    }

    it("should have value 70") {
      siz.value shouldBe 70
    }
  }
}