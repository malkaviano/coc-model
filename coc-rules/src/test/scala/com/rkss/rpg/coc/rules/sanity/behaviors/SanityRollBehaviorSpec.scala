package com.rkss.rpg.coc.rules.sanity.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.rules.testing.fakes._
import com.rkss.rpg.coc.rules.testing._
import com.rkss.rpg.coc.concepts.sanity._
import com.rkss.rpg.coc.concepts._

final class SanityRollBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Sanity roll behavior") {
    val sanity = new FakeSanity(60)

    describe("Sanity roll") {
      it should behave like sanityRoll(sanity, 100, Fumble)

      it should behave like sanityRoll(sanity, 20, SuccessResult)

      it should behave like sanityRoll(sanity, 97, FailureResult)

      it should behave like sanityRoll(new FakeSanity(40), 97, Fumble)
    }
  }

  private def sanityRoll(
      sanity: Sanity,
      rolled: Int,
      result: SanityRolledResult
  ) = {
    describe(s"when sanity is ${sanity.current}") {
      describe(s"when rolling a ${rolled}") {
        val hundredSidedDice =
          HundredSidedDice(TestingProps.fakeRng(Seq(rolled)))

        val expected = SanityRolled(
          sanity.current,
          sanity.maximum,
          result,
          RollDiceResult(rolled)
        )

        it(s"return ${expected}") {
          val result = sanity.roll(hundredSidedDice)

          result shouldBe expected
        }
      }
    }
  }
}
