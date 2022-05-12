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
          Characteristic(Strength, 40),
          Characteristic(Dexterity, 40),
          Characteristic(Size, 40),
          8
        ),
        (
          Characteristic(Strength, 50),
          Characteristic(Dexterity, 40),
          Characteristic(Size, 40),
          8
        ),
        (
          Characteristic(Strength, 40),
          Characteristic(Dexterity, 60),
          Characteristic(Size, 40),
          8
        ),
        (
          Characteristic(Strength, 40),
          Characteristic(Dexterity, 60),
          Characteristic(Size, 80),
          7
        ),
        (
          Characteristic(Strength, 70),
          Characteristic(Dexterity, 60),
          Characteristic(Size, 50),
          9
        )
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
