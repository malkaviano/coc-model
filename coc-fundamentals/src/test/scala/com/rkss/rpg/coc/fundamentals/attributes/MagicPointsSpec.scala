package com.rkss.rpg.coc.fundamentals.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.helpers.basicint._

final class MagicPointsSpec extends AnyFunSpec with Matchers {
  describe("Magic Points Behavior") {
    describe("when Power is 60") {
      describe("Current value") {
        it(s"should be 12") {
          val power = Characteristic(Power, 60)

          val mp = MagicPoints(power)

          mp.current shouldBe 12
        }
      }

      describe("Maximum value") {
        it("should be 12") {
          val power = Characteristic(Power, 60)

          val mp = MagicPoints(power)

          mp.maximum shouldBe 12
        }

        describe("when Power drops to 50") {
          it("should return 10") {
            val power = Characteristic(Power, 60)

            val mp = MagicPoints(power)

            power.decrease(BasicIntValue(Power, 10))

            mp.maximum shouldBe 10
          }
        }
      }
    }
  }
}
