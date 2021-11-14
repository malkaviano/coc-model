package com.malk.coc.concepts.abstractions

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

class CubeDiceSpec extends AnyFunSpec with Matchers with MockFactory {
  describe("Cube Dice roll") {
    val roll6 = mockFunction[(Int, Int), Int]

    val dice = CubeDice(roll6)

    it("should have name D6") {
      dice.name shouldBe "D6"
    }

    it("should have range (1, 6)") {
      CubeDice.range shouldBe ((1, 6))
    }

    it("should have roll generating a number between (1, 6)") {
      roll6.expects((1, 6)).once().returning(3)

      dice.roll shouldBe 3
    }
  }
}
