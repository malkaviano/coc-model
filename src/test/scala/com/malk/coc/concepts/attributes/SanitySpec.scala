package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.malk.coc.concepts.characteristics.Power
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.concepts.characteristics.Intelligence

class SanitySpec extends AnyFunSpec with Matchers {
  describe("Sanity Attribute") {
    val brain = Brain(Intelligence(50), Power(60))
    val sanity = Sanity(brain)

    it("should have name equal SAN") {
      sanity.name shouldBe "SAN"
    }

    val expected = brain.power.value
    it(s"should have value equal ${expected}") {
      sanity.value shouldBe expected
    }
  }
}
