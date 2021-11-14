package com.malk.coc.concepts.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class DeltohedronDiceSpec extends AnyFunSpec
    with Matchers
    with MockFactory
    with BehavesLikeDice {
  describe("Deltohedron Dice") {
    val rollD10 = mockFunction[(Int, Int), Int]

    val dice = DeltohedronDice(rollD10)

    val name = "D10"
    val range = DeltohedronDice.range

    behavesLikeDice(dice, name, range, rollD10, 9)

    it(s"should have range (1, 10)") {
      DeltohedronDice.range shouldBe ((1, 10))
    }
  }
}