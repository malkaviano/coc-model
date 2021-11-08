package com.malk.coc.traits

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class MentalCapacitySpec extends AnyFunSpec with Matchers {
  val mc = new MentalCapacity {
    def INT: Int = 80
    def POW: Int = 75
  }

  it("should have INT (Intelligence) value") {
    mc.INT shouldBe 80
  }

  it("should have POW (Power) value") {
    mc.POW shouldBe 75
  }
}