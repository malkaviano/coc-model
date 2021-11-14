package com.malk.coc.concepts.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class CubeDiceSpec extends AnyFunSpec with Matchers with MockFactory with BehavesLikeDice {
  describe("Cube Dice roll") {
    val rollD6 = mockFunction[(Int, Int), Int]

    val dice = CubeDice(rollD6)

    val name = "D6"
    val range = CubeDice.range

    behavesLikeDice(dice, name, range, rollD6, 5)

    it(s"should have range (1, 6)") {
      CubeDice.range shouldBe ((1, 6))
    }
  }
}
