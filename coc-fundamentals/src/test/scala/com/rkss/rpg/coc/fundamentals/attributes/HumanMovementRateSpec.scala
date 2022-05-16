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
          Age(30),
          8
        ),
        (
          Characteristic(Strength, 50),
          Characteristic(Dexterity, 40),
          Characteristic(Size, 40),
          Age(30),
          8
        ),
        (
          Characteristic(Strength, 40),
          Characteristic(Dexterity, 60),
          Characteristic(Size, 40),
          Age(30),
          8
        ),
        (
          Characteristic(Strength, 40),
          Characteristic(Dexterity, 60),
          Characteristic(Size, 80),
          Age(30),
          7
        ),
        (
          Characteristic(Strength, 70),
          Characteristic(Dexterity, 60),
          Characteristic(Size, 50),
          Age(30),
          9
        ),
        (
          Characteristic(Strength, 40),
          Characteristic(Dexterity, 60),
          Characteristic(Size, 40),
          Age(52),
          6
        )
      ).foreach {
        case (strength, dexterity, size, age, expected) => {
          describe(s"when $strength - $dexterity - $size") {
            it(s"should be $expected") {
              val mov = HumanMovementRate(strength, dexterity, size, age)

              mov.current shouldBe expected
            }
          }
        }
      }
    }
  }
}
