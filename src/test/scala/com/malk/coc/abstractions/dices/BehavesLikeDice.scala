package com.malk.coc.abstractions.dices

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory
import org.scalamock.function.MockFunction1

import com.malk.coc.traits.Dice

trait BehavesLikeDice extends AnyFunSpec with Matchers with MockFactory {
  def behavesLikeDice(
      dice: Dice,
      name: String,
      range: DiceRange,
      mock: MockFunction1[DiceRange, Int],
      expected: Int
  ) = {
    it(s"should have name ${name}") {
      dice.name shouldBe name
    }

    it(s"should have roll generating a number between ${range}") {
      mock.expects(range).once().returning(expected)

      dice.roll shouldBe expected
    }
  }
}
