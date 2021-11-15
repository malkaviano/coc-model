package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class SanitySpec extends AnyFunSpec with Matchers {
  describe("Sanity Attribute") {
    val sanity = Sanity(60)

    it("should have name equal SAN") {
      sanity.name shouldBe "SAN"
    }

    val expected = 60
    it(s"should have value equal ${expected}") {
      sanity.value shouldBe expected
    }
  }
}
