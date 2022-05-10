package com.rkss.rpg.coc.fundamentals.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.behaviors.testing._
import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.coc.fundamentals.skills._
import com.rkss.rpg.coc.concepts.results._

final class SanityRollBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Sanity roll behavior") {
    val sanity =
      Sanity(PrimaryCharacteristic(Power, 60), CthulhuMythosSkillImpl())

    describe("Sanity roll") {
      it should behave like sanityRoll(sanity, 100, SanityRollFumble)

      it should behave like sanityRoll(sanity, 20, SanityRollSuccessResult)

      it should behave like sanityRoll(sanity, 97, SanityRollFailureResult)

      it should behave like sanityRoll(
        Sanity(
          PrimaryCharacteristic(Power, 40),
          CthulhuMythosSkillImpl()
        ),
        97,
        SanityRollFumble
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
          DiceRolled(rolled)
        )

        it(s"return ${expected}") {
          val result = sanity.roll(hundredSidedDice)

          result shouldBe expected
        }
      }
    }
  }
}
