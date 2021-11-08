package com.malk.coc.traits

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class FightingManeuverModifierSpec extends AnyFunSpec with Matchers {
  val fmm = new FightingManeuverModifier {
    def Build: Int = 3
  }

  it("should have Build value") {
    fmm.Build shouldBe 3
  }
}