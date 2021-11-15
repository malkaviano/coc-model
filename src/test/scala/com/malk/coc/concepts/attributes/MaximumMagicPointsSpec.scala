package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class MaximumMagicPointsSpec extends AnyFunSpec with Matchers with MaximumHitPointsBehaviors {
  describe("The Maximum Magic Points") {
    val hp = MaximumMagicPoints(30)

    it("should have name Maximum Magic Points") {
      hp.name shouldBe "Maximum Magic Points"
    }

    it("should have value 30") {
      hp.value shouldBe 30
    }
  }
}