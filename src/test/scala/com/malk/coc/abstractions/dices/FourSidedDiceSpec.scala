package com.malk.coc.abstractions.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class FourSidedDiceSpec
    extends AnyFunSpec
    with Matchers
    with MockFactory
    with BehavesLikeDice {
  describe("Four Sided Dice roll") {
    val rollD4 = mockFunction[DiceRange, Int]

    val dice = FourSidedDice(rollD4)

    val name = "D4"
    val range = FourSidedDice.range

    behavesLikeDice(dice, name, range, rollD4, 2)

    it(s"should have range (1, 4)") {
      FourSidedDice.range shouldBe (DiceRange(1, 4))
    }
  }
}
