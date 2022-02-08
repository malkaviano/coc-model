package com.rkss.rpg.coc.fundamentals.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.commons._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._

final class InvestigatorMagicPointsSpec extends AnyFunSpec with Matchers {
  describe("Magic Points Behavior") {
    describe("Current value") {
      it(s"should be 12") {
        val power = PrimaryCharacteristic(Power, 60)

        val mp = MagicPointsImpl(power)

        mp.current shouldBe 12
      }

      describe("when maximum drops bellow current") {
        it("should reduce current to the maximum") {
          val power = PrimaryCharacteristic(Power, 60)

          val mp = MagicPointsImpl(power)

          power.modify(ValueModification(Power, -10))

          mp.current shouldBe 10
        }
      }
    }

    describe("Maximum value") {
      it("should be 12") {
        val power = PrimaryCharacteristic(Power, 60)

        val mp = MagicPointsImpl(power)

        mp.maximum shouldBe 12
      }

      describe(s"when current power change to 60") {
        it(s"should be 16") {
          val power = PrimaryCharacteristic(Power, 60)

          val mp = MagicPointsImpl(power)

          power.modify(ValueModification(Power, 20))

          mp.maximum shouldBe 16
        }
      }
    }
  }
}
