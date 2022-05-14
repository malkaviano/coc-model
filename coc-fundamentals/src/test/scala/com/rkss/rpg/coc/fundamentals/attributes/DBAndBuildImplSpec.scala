package com.rkss.rpg.coc.fundamentals.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.behaviors.testing._

final class DBAndBuildImplSpec extends AnyFunSpec with Matchers {
  describe("DamageBonus and Build Behavior") {
    describe("Current value") {
      Seq(
        (
          Characteristic(Strength, 32),
          Characteristic(Size, 32),
          -2,
          -2
        ),
        (
          Characteristic(Strength, 42),
          Characteristic(Size, 42),
          -1,
          -1
        ),
        (
          Characteristic(Strength, 62),
          Characteristic(Size, 62),
          0,
          0
        ),
        (
          Characteristic(Strength, 82),
          Characteristic(Size, 82),
          4,
          1
        ),
        (
          Characteristic(Strength, 102),
          Characteristic(Size, 102),
          6,
          2
        ),
        (
          Characteristic(Strength, 142),
          Characteristic(Size, 142),
          12,
          3
        ),
        (
          Characteristic(Strength, 182),
          Characteristic(Size, 182),
          18,
          4
        ),
        (
          Characteristic(Strength, 222),
          Characteristic(Size, 222),
          24,
          5
        ),
        (
          Characteristic(Strength, 262),
          Characteristic(Size, 262),
          30,
          6
        ),
        (
          Characteristic(Strength, 300),
          Characteristic(Size, 300),
          36,
          7
        )
      ).foreach {
        case (strength, size, expectedDB, expectedBuild) => {
          describe(s"when $strength - $size") {
            it(s"should have Build $expectedBuild") {
              val build = Build(strength, size)

              build.current shouldBe expectedBuild
            }

            it(s"should have Damage Bonus $expectedDB") {
              val fourSidedDice =
                FourSidedDice(TestingProps.fakeRng(Seq(4)))

              val sixSidedDice =
                SixSidedDice(TestingProps.fakeRng(Seq(6, 6, 6, 6, 6, 6)))

              val db =
                DamageBonus(strength, size)(fourSidedDice, sixSidedDice)

              db.current shouldBe expectedDB
            }
          }
        }
      }
    }
  }
}
