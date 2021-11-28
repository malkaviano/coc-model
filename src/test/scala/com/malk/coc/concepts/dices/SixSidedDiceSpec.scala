package com.malk.coc.concepts.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class SixSidedDiceSpec extends AnyFunSpec with Matchers with MockFactory with BehavesLikeDice {
  describe("Six Sided roll") {
    val rollD6 = mockFunction[DiceRange, Int]

    val dice = SixSidedDice(rollD6)

    val name = "D6"
    val range = SixSidedDice.range

    behavesLikeDice(dice, name, range, rollD6, 5)

    it(s"should have range (1, 6)") {
      SixSidedDice.range shouldBe (DiceRange(1, 6))
    }
  }
}
