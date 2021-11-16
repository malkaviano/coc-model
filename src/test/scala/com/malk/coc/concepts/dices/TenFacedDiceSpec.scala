package com.malk.coc.concepts.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class TenFacedDiceSpec extends AnyFunSpec
    with Matchers
    with MockFactory
    with BehavesLikeDice {
  describe("Deltohedron Dice") {
    val rollD10 = mockFunction[(Int, Int), Int]

    val dice = TenFacedDice(rollD10)

    val name = "D10"
    val range = TenFacedDice.range

    behavesLikeDice(dice, name, range, rollD10, 9)

    it(s"should have range (1, 10)") {
      TenFacedDice.range shouldBe ((1, 10))
    }
  }
}