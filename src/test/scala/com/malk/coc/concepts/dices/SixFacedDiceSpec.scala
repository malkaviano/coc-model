package com.malk.coc.concepts.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class SixFacedDiceSpec extends AnyFunSpec with Matchers with MockFactory with BehavesLikeDice {
  describe("Cube Dice roll") {
    val rollD6 = mockFunction[(Int, Int), Int]

    val dice = SixFacedDice(rollD6)

    val name = "D6"
    val range = SixFacedDice.range

    behavesLikeDice(dice, name, range, rollD6, 5)

    it(s"should have range (1, 6)") {
      SixFacedDice.range shouldBe ((1, 6))
    }
  }
}
