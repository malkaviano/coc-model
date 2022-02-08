package com.rkss.rpg.coc.fundamentals.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

final class HumanAgeSpec extends AnyFunSpec with Matchers {
  describe("Age behavior") {
    describe("Age current") {
      it("should be 20") {
        val age = HumanAge(20)

        age.current shouldBe 20
      }
    }
  }
}
