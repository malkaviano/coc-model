package com.rkss.rpg.coc.rules.sanity.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.rkss.rpg.coc.rules.testing.fakes.FakeSanity

final class SanityBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Sanity Behavior") {
    val initial = 40

    describe("Initial value") {
      it(s"should be ${initial}") {
        val sanity = FakeSanity(initial)

        sanity.current shouldBe initial
      }
    }

    describe("Current value") {
      it(s"should be ${initial}") {
        val sanity = FakeSanity(initial)

        sanity.current shouldBe initial
      }
    }

    describe("Sanity loss") {
      Seq((10, 30), (-5, 35), (60, 0)).foreach {
        case (loss, expected) => {
          it(s"should decrease current sanity by ${Math.abs(loss)}") {
            val sanity = FakeSanity(initial)

            sanity.loss(loss)

            sanity.current shouldBe expected
          }
        }
      }
    }

    describe("Sanity gain") {
      Seq((10, 50), (-5, 45), (60, 80)).foreach {
        case (gain, expected) => {
          it(s"should increase current sanity by ${Math.abs(gain)}") {
            val sanity = FakeSanity(initial)

            sanity.currentMythos(19)

            sanity.gain(gain)

            sanity.current shouldBe expected
          }
        }
      }
    }

    describe("Maximum value") {
      it("should be 99") {
        val sanity = FakeSanity(initial)

        sanity.maximum shouldBe 99
      }

      describe(s"when current mythos change to 9") {
        val expected = 90

        it(s"should be $expected") {
          val sanity = FakeSanity(initial)

          sanity.currentMythos(9)

          sanity.maximum shouldBe expected
        }
      }
    }
  }
}
