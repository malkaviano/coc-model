package com.malk.coc.concepts.skills

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.Education

class LanguageOwnSpec extends AnyFunSpec with Matchers {
  describe("The Language Own skill") {
    val edu = Education(67)

    val investigatorLanguageOwn = LanguageOwn(edu)(4)

    it("should have name Language Own") {
      investigatorLanguageOwn.name shouldBe "Language Own"
    }

    it("should have base equal 67") {
      investigatorLanguageOwn.base shouldBe 67
    }

    it("should have value equal 71") {
      investigatorLanguageOwn.value shouldBe 71
    }

    it("should have canPush equal true") {
      investigatorLanguageOwn.canPush shouldBe true
    }
  }
}