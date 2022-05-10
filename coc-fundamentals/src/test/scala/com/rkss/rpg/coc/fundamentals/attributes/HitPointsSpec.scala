package com.rkss.rpg.coc.fundamentals.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.internal._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._

final class HitPointsSpec extends AnyFunSpec with Matchers {
  describe("Hit Points Behavior") {
    describe("Current value") {
      it(s"should be 8") {
        val size = PrimaryCharacteristic(Size, 40)
        val constitution = PrimaryCharacteristic(Constitution, 40)

        val hp = HitPoints(size, constitution)

        hp.current shouldBe 8
      }

      describe("when maximum drops bellow current") {
        it("should reduce current to the maximum") {
          val size = PrimaryCharacteristic(Size, 40)
          val constitution = PrimaryCharacteristic(Constitution, 40)

          val hp = HitPoints(size, constitution)

          constitution.modify(ValueModification(Constitution, -20))

          hp.current shouldBe 6
        }
      }
    }

    describe("Maximum value") {
      it("should be 8") {
        val size = PrimaryCharacteristic(Size, 40)
        val constitution = PrimaryCharacteristic(Constitution, 40)

        val hp = HitPoints(size, constitution)

        hp.maximum shouldBe 8
      }

      describe(s"when current constitution change to 60") {
        it(s"should be 10") {
          val size = PrimaryCharacteristic(Size, 40)
          val constitution = PrimaryCharacteristic(Constitution, 40)

          val hp = HitPoints(size, constitution)

          constitution.modify(ValueModification(Constitution, 20))

          hp.maximum shouldBe 10
        }
      }
    }
  }
}
