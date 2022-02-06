package com.rkss.rpg.coc.fundamentals.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.behaviors.testing.TestingProps
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts.commons._
import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.coc.concepts.attributes._

final class LuckRollBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Roll behavior") {
    val luck = Luck(60)

    describe("when rolling above the base value") {
      val expected = LuckRolled(
        luck.baseValue,
        DiceRolled(90),
        FailureRoll
      )

      it should behave like roll(luck, expected, Seq(90))
    }

    describe("when rolling equal or inferior the base value") {
      Seq(60, 10).foreach(rolled => {
        val expected = LuckRolled(
          luck.baseValue,
          DiceRolled(rolled),
          SuccessRoll
        )

        it should behave like roll(luck, expected, Seq(rolled))
      })
    }
  }

  private def roll(
      luck: Luck,
      expected: LuckRolled,
      rolled: Seq[Int]
  ): Unit = {
    it(s"return $expected") {
      val hundredSidedDice = HundredSidedDice(
        TestingProps.fakeRng(rolled)
      )

      luck.roll(hundredSidedDice) shouldBe expected
    }
  }
}
