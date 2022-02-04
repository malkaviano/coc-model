package com.rkss.rpg.coc.helpers.factories

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.coc.rules.testing.TestingProps
import com.rkss.rpg.helpers.dice._

final class CharacteristicFactorySpec extends AnyFunSpec with Matchers {
  describe("Characteristic Factory") {
    Seq(
      (Strength, 50, Seq(5, 4, 1)),
      (Constitution, 45, Seq(2, 4, 3)),
      (Dexterity, 55, Seq(2, 3, 6)),
      (Appearance, 40, Seq(5, 2, 1)),
      (Power, 80, Seq(5, 6, 5)),
      (Intelligence, 55, Seq(2, 3)),
      (Education, 65, Seq(5, 2)),
      (Size, 90, Seq(6, 6)),
    ).foreach {
      case (name, expected, rolled) => {
        describe("creating strength characteristic") {
          describe("when base value is informed") {
            it(s"should return ${name}(${expected})") {
              val char = CharacteristicFactory.characteristic(name, expected)

              char shouldBe PrimaryCharacteristic(name, expected)
            }
          }

          describe("when using rng") {
            it(s"should return ${name}(${expected})") {
              val dice = TestingProps.fakeRng(rolled)

              val char = CharacteristicFactory.characteristic(name)(
                SixSidedDice(dice)
              )

              char shouldBe PrimaryCharacteristic(name, expected)
            }
          }
        }

      }
    }

  }
}
