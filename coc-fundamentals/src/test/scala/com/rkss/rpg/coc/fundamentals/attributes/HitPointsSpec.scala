package com.rkss.rpg.coc.fundamentals.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.helpers.basicint._
import com.rkss.rpg.helpers._
import com.rkss.rpg.coc.concepts.attributes._

final class HitPointsSpec extends AnyFunSpec with Matchers {
  describe("Hit Points Behavior") {
    describe("Constitution and Size are 40") {
      describe("when constitution drops to 20") {
        describe("current and maximum") {
          it("should be 6") {
            val size = Characteristic(Size, 40)
            val constitution = Characteristic(Constitution, 40)

            val hp = HitPoints(size, constitution)

            constitution.decrease(BasicIntValue(Constitution, 20))

            hp.current shouldBe 6

            hp.maximum shouldBe 6
          }
        }
      }
      describe("when size increases to 60") {
        describe("maximum value") {
          it(s"should be 10") {
            val size = Characteristic(Size, 40)
            val constitution = Characteristic(Constitution, 40)

            val hp = HitPoints(size, constitution)

            size.increase(BasicIntValue(Size, 20))

            hp.maximum shouldBe 10
          }
        }
      }

      describe(s"when size maximum change to 80") {
        it(s"should keep same value") {
          val size = Characteristic(Size, 40)
          val constitution = Characteristic(Constitution, 40)

          val hp = HitPoints(size, constitution)

          EventHub.shout(
            size.id,
            BasicIntEvent(
              HitPointsAttribute,
              80,
              80,
              size.id,
              BasicIntTargetMaximum
            )
          )

          hp.maximum shouldBe 8
        }
      }
    }
  }
}
