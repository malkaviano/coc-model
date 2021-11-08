package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class AttributeSpec extends AnyFunSpec with Matchers {
  describe("An attribute") {
    val attr = new Attribute("attr") {
      def value: Int = 0
    }

    it("should have a name") {
      attr.name shouldBe "attr"
    }

    it("should have a value") {
      attr.value shouldBe 0
    }
  }
}