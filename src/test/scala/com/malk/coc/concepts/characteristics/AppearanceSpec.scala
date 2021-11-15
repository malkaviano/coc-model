package com.malk.coc.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class AppearanceSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.helpers.CharacteristicModifications.implicits._

  describe("The Appearance") {
    val app = Appearance(65)

    it("should have name Appearance") {
      app.name shouldBe "APP"
    }

    it("should have value 65") {
      app.value shouldBe 65
    }

    describe(s"when ${app} - 10") {
      val expected = Appearance(55)

      it(s"should return ${expected}") {
        val result = app - 10

        result shouldBe expected
      }
    }

    describe(s"when ${app} + 6") {
      val expected = Appearance(71)

      it(s"should return ${expected}") {
        val result = app + 6

        result shouldBe expected
      }
    }
  }
}