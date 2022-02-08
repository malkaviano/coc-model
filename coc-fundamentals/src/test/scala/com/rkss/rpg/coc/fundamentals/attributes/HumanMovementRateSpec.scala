package com.rkss.rpg.coc.fundamentals.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._

final class HumanMovementRateSpec extends AnyFunSpec with Matchers {
  describe("Movement Rate Behavior") {
    describe("Current value") {
      Seq(
        (
          PrimaryCharacteristic(Strength, 40),
          PrimaryCharacteristic(Dexterity, 40),
          PrimaryCharacteristic(Size, 40),
          8
        ),
        (
          PrimaryCharacteristic(Strength, 50),
          PrimaryCharacteristic(Dexterity, 40),
          PrimaryCharacteristic(Size, 40),
          8
        ),
        (
          PrimaryCharacteristic(Strength, 40),
          PrimaryCharacteristic(Dexterity, 60),
          PrimaryCharacteristic(Size, 40),
          8
        ),
        (
          PrimaryCharacteristic(Strength, 40),
          PrimaryCharacteristic(Dexterity, 60),
          PrimaryCharacteristic(Size, 80),
          7
        ),
        (
          PrimaryCharacteristic(Strength, 70),
          PrimaryCharacteristic(Dexterity, 60),
          PrimaryCharacteristic(Size, 50),
          9
        ),
      ).foreach {
        case (strength, dexterity, size, expected) => {
          describe(s"when $strength - $dexterity - $size") {
            it(s"should be $expected") {
              val mov = HumanMovementRate(strength, dexterity, size)

              mov.current shouldBe expected
            }
          }
        }
      }
    }
  }
}
