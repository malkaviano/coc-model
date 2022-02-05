package com.rkss.rpg.coc.fundamentals.sanity

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.behaviors.testing._
import com.rkss.rpg.coc.concepts.sanity._
import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.attributes._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.coc.fundamentals.skills._

final class SanityRollBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Sanity roll behavior") {
    val sanity =
      InvestigatorSanity(PrimaryCharacteristic(Power, 60), CthulhuMythosSkill())

    describe("Sanity roll") {
      it should behave like sanityRoll(sanity, 100, Fumble)

      it should behave like sanityRoll(sanity, 20, SuccessResult)

      it should behave like sanityRoll(sanity, 97, FailureResult)

      it should behave like sanityRoll(
        InvestigatorSanity(
          PrimaryCharacteristic(Power, 40),
          CthulhuMythosSkill()
        ),
        97,
        Fumble
      )
    }
  }

  private def sanityRoll(
      sanity: Sanity,
      rolled: Int,
      result: SanityRollResult
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
