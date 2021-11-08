package com.malk.coc.traits

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class MobilitySpec extends AnyFunSpec with Matchers {
  val mobility = new Mobility {
    override def MOV: Int = 20
  }

  it("should have MOV (Movement Rate) value") {
    mobility.MOV shouldBe 20
  }
}