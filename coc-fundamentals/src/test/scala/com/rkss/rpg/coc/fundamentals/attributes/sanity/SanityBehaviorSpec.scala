package com.rkss.rpg.coc.fundamentals.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.rkss.rpg.coc.concepts.sanity._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.coc.fundamentals.skills.CthulhuMythosSkill
import com.rkss.rpg.coc.concepts.ValueModification
import com.rkss.rpg.coc.concepts.skill.CthulhuMythos

final class SanityBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Sanity Behavior") {
    val initial = PrimaryCharacteristic(Power, 40)

    describe("Initial value") {
      it(s"should be ${initial}") {
        val sanity = InvestigatorSanity(initial, CthulhuMythosSkill())

        sanity.current shouldBe initial.value()
      }
    }

    describe("Current value") {
      it(s"should be ${initial}") {
        val sanity = InvestigatorSanity(initial, CthulhuMythosSkill())

        sanity.current shouldBe initial.value()
      }

      describe("when maximum drops bellow current") {
        it("should reduce current to the maximum") {
          val mythos = CthulhuMythosSkill()

          val sanity = InvestigatorSanity(initial, mythos)

          mythos.modify(ValueModification(CthulhuMythos, 69))

          sanity.current shouldBe 30
        }
      }
    }

    describe("Sanity loss") {
      Seq(
        (SanityLoss(10), SanityLost(10, 30, 40)),
        (SanityLoss(60), SanityLost(40, 0, 40))
      ).foreach {
        case (loss, expected) => {
          it(s"should decrease current sanity by ${loss}") {
            val sanity = InvestigatorSanity(initial, CthulhuMythosSkill())

            sanity.loss(loss) shouldBe expected
          }
        }
      }
    }

    describe("Sanity gain") {
      Seq(
        (SanityGain(10), CthulhuMythosSkill(), SanityRecovered(10, 50, 40, 80)),
        (SanityGain(60), CthulhuMythosSkill(), SanityRecovered(40, 80, 40, 80))
      ).foreach {
        case (gain, mythos, expected) => {
          it(s"should increase current sanity by ${gain}") {
            mythos.modify(ValueModification(CthulhuMythos, 19))

            val sanity = InvestigatorSanity(initial, mythos)

            sanity.gain(gain) shouldBe expected
          }
        }
      }
    }

    describe("Maximum value") {
      it("should be 99") {
        val mythos = CthulhuMythosSkill()

        val sanity = InvestigatorSanity(initial, mythos)

        sanity.maximum shouldBe 99
      }

      describe(s"when current mythos change to 9") {
        it(s"should be 90") {
          val mythos = CthulhuMythosSkill()

          val sanity = InvestigatorSanity(initial, mythos)

          mythos.modify(ValueModification(CthulhuMythos, 9))

          sanity.maximum shouldBe 90
        }
      }
    }
  }
}
