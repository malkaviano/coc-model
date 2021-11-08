package com.malk.coc.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class AppearanceSpec extends AnyFunSpec with Matchers {
  describe("The Appearance") {
    val app = Appearance(65)

    it("should have name Appearance") {
      app.name shouldBe "APP"
    }

    it("should have value 65") {
      app.value shouldBe 65
    }
  }
}