package com.rkss.rpg.coc.fundamentals.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.coc.fundamentals._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.behaviors.testing._

final class DBAndBuildImplSpec extends AnyFunSpec with Matchers {
  describe("DamageBonus and Build Behavior") {
    describe("Current value") {
      Seq(
        (
          PrimaryCharacteristic(Strength, 32),
          PrimaryCharacteristic(Size, 32),
          -2,
          -2
        ),
        (
          PrimaryCharacteristic(Strength, 42),
          PrimaryCharacteristic(Size, 42),
          -1,
          -1
        ),
        (
          PrimaryCharacteristic(Strength, 62),
          PrimaryCharacteristic(Size, 62),
          0,
          0
        ),
        (
          PrimaryCharacteristic(Strength, 82),
          PrimaryCharacteristic(Size, 82),
          4,
          1
        ),
        (
          PrimaryCharacteristic(Strength, 102),
          PrimaryCharacteristic(Size, 102),
          6,
          2
        ),
        (
          PrimaryCharacteristic(Strength, 142),
          PrimaryCharacteristic(Size, 142),
          12,
          3
        ),
        (
          PrimaryCharacteristic(Strength, 182),
          PrimaryCharacteristic(Size, 182),
          18,
          4
        ),
        (
          PrimaryCharacteristic(Strength, 222),
          PrimaryCharacteristic(Size, 222),
          24,
          5
        ),
        (
          PrimaryCharacteristic(Strength, 262),
          PrimaryCharacteristic(Size, 262),
          30,
          6
        ),
        (
          PrimaryCharacteristic(Strength, 300),
          PrimaryCharacteristic(Size, 300),
          36,
          7
        )
      ).foreach {
        case (strength, size, expectedDB, expectedBuild) => {
          describe(s"when $strength - $size") {
            it(s"should have Build $expectedBuild") {
              val build = BuildImpl(strength, size)

              build.current shouldBe expectedBuild
            }

            it(s"should have Damage Bonus $expectedDB") {
              val fourSidedDice =
                FourSidedDice(TestingProps.fakeRng(Seq(4)))

              val sixSidedDice =
                SixSidedDice(TestingProps.fakeRng(Seq(6, 6, 6, 6, 6, 6)))

              val db = DamageBonusImpl(strength, size)(fourSidedDice, sixSidedDice)

              db.current shouldBe expectedDB
            }
          }
        }
      }
    }
  }
}
