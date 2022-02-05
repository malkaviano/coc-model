package com.rkss.rpg.coc.helpers.generators

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.behaviors.testing._
import com.rkss.rpg.helpers.dice._

final class RngValuesGeneratorSpec extends AnyFunSpec with Matchers {
  describe("Generating random values") {
    Seq(
      (3, 5, 0, Seq(4, 3, 2), 45),
      (2, 5, 6, Seq(3, 1), 50)
    ).foreach {
      case (dices, multiply, sum, rolled, expected) => {
        describe(s"generating ${dices}D6 * ${multiply} + ${sum}") {
          it(s"should return $expected") {
            val dice = TestingProps.fakeRng(rolled)

            val value = RngValuesGenerator.creationValue(dices, multiply, sum)(
              SixSidedDice(dice)
            )

            value shouldBe expected
          }
        }
      }
    }
  }
}
