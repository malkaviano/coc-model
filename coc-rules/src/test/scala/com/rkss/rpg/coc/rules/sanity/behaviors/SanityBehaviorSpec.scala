package com.rkss.rpg.coc.rules.sanity.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.rkss.rpg.coc.rules.testing.fakes.FakeSanity
import com.rkss.rpg.coc.concepts.sanity._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.rules.testing.fakes._

final class SanityBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Sanity Behavior") {
    val initial = FakeGenericCharacteristic(Power, 40)

    describe("Initial value") {
      it(s"should be ${initial}") {
        val sanity = FakeSanity(initial)

        sanity.current shouldBe initial.value()
      }
    }

    describe("Current value") {
      it(s"should be ${initial}") {
        val sanity = FakeSanity(initial)

        sanity.current shouldBe initial.value()
      }
    }

    describe("Sanity loss") {
      Seq(
        (SanityLoss(10), SanityLost(10, 30, 40)),
        (SanityLoss(60), SanityLost(40, 0, 40))
      ).foreach {
        case (loss, expected) => {
          it(s"should decrease current sanity by ${loss}") {
            val sanity = FakeSanity(initial)

            sanity.loss(loss) shouldBe expected
          }
        }
      }
    }

    describe("Sanity gain") {
      Seq(
        (SanityGain(10), SanityRecovered(10, 50, 40, 80)),
        (SanityGain(60), SanityRecovered(40, 80, 40, 80))
      ).foreach {
        case (gain, expected) => {
          it(s"should increase current sanity by ${gain}") {
            val sanity = FakeSanity(initial)

            sanity.currentMythos(19)

            sanity.gain(gain) shouldBe expected
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
