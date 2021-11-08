package com.malk.coc.concepts.characteristics

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
  }
}