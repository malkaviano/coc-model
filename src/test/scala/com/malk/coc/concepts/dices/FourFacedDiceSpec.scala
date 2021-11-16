package com.malk.coc.concepts.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class FourFacedDiceSpec
    extends AnyFunSpec
    with Matchers
    with MockFactory
    with BehavesLikeDice {
  describe("Tetrahedron Dice roll") {
    val rollD4 = mockFunction[(Int, Int), Int]

    val dice = FourFacedDice(rollD4)

    val name = "D4"
    val range = FourFacedDice.range

    behavesLikeDice(dice, name, range, rollD4, 2)

    it(s"should have range (1, 4)") {
      FourFacedDice.range shouldBe ((1, 4))
    }
  }
}
