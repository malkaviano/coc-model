package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.{Strength, Dexterity, Size}
import com.malk.coc.rules.HumanMobility
import com.malk.coc.helpers.Dice

class MovementRateSpec
    extends AnyFunSpec
    with Matchers {
  describe("The MovementRate") {
    val mr = MovementRate(8)

    it("should have name MOV") {
      mr.name shouldBe "MOV"
    }

    it("should have value") {
      mr.value shouldBe 8
    }
  }
}
