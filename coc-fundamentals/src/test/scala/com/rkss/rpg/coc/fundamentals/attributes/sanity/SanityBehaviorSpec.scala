package com.rkss.rpg.coc.fundamentals.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.fundamentals.skills._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.helpers.basicint._
import com.rkss.rpg.helpers._

final class SanityBehaviorSpec extends AnyFunSpec with Matchers {
  describe("Sanity Behavior") {
    val initial = Characteristic(Power, 40)

    describe("Initial value") {
      it(s"should be ${initial}") {
        val sanity = Sanity(initial, CthulhuMythosSkillImpl())

        sanity.current shouldBe initial.value()
      }
    }

    describe("Current value") {
      it(s"should be ${initial}") {
        val sanity = Sanity(initial, CthulhuMythosSkillImpl())

        sanity.current shouldBe initial.value()
      }
    }

    describe("Maximum value") {
      it("should be 99") {
        val mythos = CthulhuMythosSkillImpl()

        val sanity = Sanity(initial, mythos)

        sanity.maximum shouldBe 99
      }

      describe(s"when current mythos change to 9") {
        it(s"should be 90") {
          val mythos = CthulhuMythosSkillImpl()

          val sanity = Sanity(initial, mythos)

          mythos.increase(BasicIntValue(CthulhuMythos, 9))

          sanity.maximum shouldBe 90
        }
      }

      describe(s"when maximum mythos change to 100") {
        it(s"should keep same value") {
          val mythos = CthulhuMythosSkillImpl()

          val sanity = Sanity(initial, mythos)

          EventHub.shout(
            BasicIntEvent(
              CthulhuMythos,
              100,
              100,
              mythos.id,
              BasicIntTargetMaximum
            )
          )

          sanity.maximum shouldBe 99
        }
      }
    }
  }
}
