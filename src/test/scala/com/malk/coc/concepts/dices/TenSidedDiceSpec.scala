package com.malk.coc.concepts.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class TenSidedDiceSpec extends AnyFunSpec
    with Matchers
    with MockFactory
    with BehavesLikeDice {
  describe("Ten Sided Dice") {
    val rollD10 = mockFunction[DiceRange, Int]

    val dice = TenSidedDice(rollD10)

    val name = "D10"
    val range = TenSidedDice.range

    behavesLikeDice(dice, name, range, rollD10, 9)

    it(s"should have range (1, 10)") {
      TenSidedDice.range shouldBe (DiceRange(1, 10))
    }
  }
}