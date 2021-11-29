package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.traits.Characteristic
import com.malk.coc.abstractions.dices.HundredSidedDice
import com.malk.coc.concepts.characteristics._
import com.malk.coc.abstractions.dices.DiceRange

trait BehavesLikeCharacteristicRollCheck
    extends AnyFunSpec
    with Matchers
    with MockFactory {
  def behavesLikeCharacteristicRollCheck(
      characteristic: Characteristic
  ): Unit = {
    describe(s"when ${characteristic}") {
      val range = HundredSidedDice.range

      val required = characteristic.value

      Seq(
        (
          RollRules.RegularDifficulty,
          Seq(
            (required / 5, RollRules.ExtremeSuccessResult),
            (required / 2, RollRules.HardSuccessResult),
            (required, RollRules.SuccessResult),
            (required + 1, RollRules.FailureResult),
            (
              98,
              if (required < 50) RollRules.FumbleResult
              else RollRules.FailureResult
            )
          )
        ),
        (
          RollRules.HardDifficulty,
          Seq(
            ((required / 2) / 5, RollRules.ExtremeSuccessResult),
            ((required / 2) / 2, RollRules.HardSuccessResult),
            ((required / 2), RollRules.SuccessResult),
            ((required / 2) + 1, RollRules.FailureResult),
            (
              98,
              if ((required / 2) < 50) RollRules.FumbleResult
              else RollRules.FailureResult
            )
          )
        ),
        (
          RollRules.ExtremeDifficulty,
          Seq(
            ((required / 5) / 5, RollRules.ExtremeSuccessResult),
            ((required / 5) / 2, RollRules.HardSuccessResult),
            ((required / 5), RollRules.SuccessResult),
            ((required / 5) + 1, RollRules.FailureResult),
            (
              98,
              if ((required / 5) < 50) RollRules.FumbleResult
              else RollRules.FailureResult
            )
          )
        )
      ).foreach(
        (t: (
            RollRules.RollDifficulty,
            Seq[(Int, RollRules.RollResult)]
        )) => {
          val difficulty = t._1

          describe(s"when difficulty is ${difficulty}") {
            t._2.foreach((r: (Int, RollRules.RollResult)) => {
              val rolled = r._1
              val expected = r._2

              if (rolled > 1) {
                describe(s"when roll is equal ${rolled}") {
                  it(s"should return ${expected}") {
                    val rollD100 = mockFunction[DiceRange, Int]
                    rollD100.expects(range).once().returning(rolled)

                    val hundredSidedDice = HundredSidedDice(rollD100)

                    val result =
                      RollRules.characteristicCheck(
                        characteristic,
                        difficulty
                      )(
                        hundredSidedDice
                      )

                    result shouldBe expected
                  }
                }
              }
            })
          }
        }
      )
    }
  }
}

class RollRulesSpec
    extends AnyFunSpec
    with Matchers
    with BehavesLikeCharacteristicRollCheck {
  describe("Roll Check Rules") {
    describe("Characteristic check") {
      Seq(
        Strength(60),
        Dexterity(40),
        Constitution(20),
        Appearance(15),
        Appearance(9)
      ).foreach(characteristic => {
        describe(s"when ${characteristic}") {
          val range = HundredSidedDice.range

          describe("when rolling 100") {
            it("should return Fumble") {
              val rollD100 = mockFunction[DiceRange, Int]
              rollD100.expects(range).once().returning(100)

              val hundredSidedDice = HundredSidedDice(rollD100)

              val result =
                RollRules.characteristicCheck(characteristic)(
                  hundredSidedDice
                )

              result shouldBe RollRules.FumbleResult
            }
          }

          describe("when rolling 1") {
            it("should return Critical Success") {
              val rollD100 = mockFunction[DiceRange, Int]
              rollD100.expects(range).once().returning(1)

              val hundredSidedDice = HundredSidedDice(rollD100)

              val result =
                RollRules.characteristicCheck(characteristic)(
                  hundredSidedDice
                )

              result shouldBe RollRules.CriticalSuccessResult
            }
          }

          it should behave like behavesLikeCharacteristicRollCheck(
            characteristic
          )
        }
      })
    }
  }

  describe("Roll Results") {
    behavesLikeRollResult(RollRules.FumbleResult, false)
    behavesLikeRollResult(RollRules.FailureResult, false)
    behavesLikeRollResult(RollRules.SuccessResult, true)
    behavesLikeRollResult(RollRules.HardSuccessResult, true)
    behavesLikeRollResult(RollRules.ExtremeSuccessResult, true)
    behavesLikeRollResult(RollRules.CriticalSuccessResult, true)

    describe(s"when ${Size(4)}") {
      describe("when Extreme difficulty") {
        it("should throw an RuntimeException *Impossible to succeed") {
          val rollD100 = mockFunction[DiceRange, Int]

          val hundredSidedDice = HundredSidedDice(rollD100)

          val thrown = the[RuntimeException] thrownBy RollRules
            .characteristicCheck(Size(4), RollRules.ExtremeDifficulty)(
              hundredSidedDice
            )

          thrown.getMessage shouldBe ("Impossible to succeed")
        }
      }
    }
  }

  def behavesLikeRollResult(result: RollRules.RollResult, expected: Boolean) = {
    import com.malk.coc.rules.RollRules.RollResult.implicits._

    describe(s"${result}") {
      it(s"should be implicit converted to ${expected}") {
        val converted: Boolean = result

        converted shouldBe expected
      }
    }
  }
}
