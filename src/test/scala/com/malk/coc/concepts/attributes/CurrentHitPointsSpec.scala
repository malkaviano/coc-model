package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class CurrentHitPointsSpec extends AnyFunSpec with Matchers {
  describe("The Current Hit Points") {
    val hp = CurrentHitPoints(10)

    it("should have name Current Hit Points") {
      hp.name shouldBe "Current Hit Points"
    }

    it("should have value") {
      hp.value shouldBe 10
    }
  }
}