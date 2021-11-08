package com.malk.coc.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class EducationSpec extends AnyFunSpec with Matchers {
  describe("The Education") {
    val edu = Education(69)

    it("should have name EDU") {
      edu.name shouldBe "EDU"
    }

    it("should have value 69") {
      edu.value shouldBe 69
    }
  }
}