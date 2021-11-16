package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

import com.malk.coc.concepts.characteristics.Strength
import com.malk.coc.traits.Characteristic
import com.malk.coc.concepts.dices.HundredSidedDice
import com.malk.coc.concepts.characteristics._

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
          RollCheckRules.RegularDifficulty,
          Seq(
            (required / 5, RollCheckRules.ExtremeSuccessResult),
            (required / 2, RollCheckRules.HardSuccessResult),
            (required, RollCheckRules.SuccessResult),
            (required + 1, RollCheckRules.FailureResult),
            (
              98,
              if (required < 50) RollCheckRules.FumbleResult
              else RollCheckRules.FailureResult
            )
          )
        ),
        (
          RollCheckRules.HardDifficulty,
          Seq(
            ((required / 2) / 5, RollCheckRules.ExtremeSuccessResult),
            ((required / 2) / 2, RollCheckRules.HardSuccessResult),
            ((required / 2), RollCheckRules.SuccessResult),
            ((required / 2) + 1, RollCheckRules.FailureResult),
            (
              98,
              if ((required / 2) < 50) RollCheckRules.FumbleResult
              else RollCheckRules.FailureResult
            )
          )
        ),
        (
          RollCheckRules.ExtremeDifficulty,
          Seq(
            ((required / 5) / 5, RollCheckRules.ExtremeSuccessResult),
            ((required / 5) / 2, RollCheckRules.HardSuccessResult),
            ((required / 5), RollCheckRules.SuccessResult),
            ((required / 5) + 1, RollCheckRules.FailureResult),
            (
              98,
              if ((required / 5) < 50) RollCheckRules.FumbleResult
              else RollCheckRules.FailureResult
            )
          )
        )
      ).foreach(
        (t: (
            RollCheckRules.RollDifficulty,
            Seq[(Int, RollCheckRules.RollResult)]
        )) => {
          val difficulty = t._1

          describe(s"when difficulty is ${difficulty}") {
            t._2.foreach((r: (Int, RollCheckRules.RollResult)) => {
              val rolled = r._1
              val expected = r._2

              if (rolled > 1) {
                describe(s"when roll is equal ${rolled}") {
                  it(s"should return ${expected}") {
                    val rollD100 = mockFunction[(Int, Int), Int]
                    rollD100.expects(range).once().returning(rolled)

                    val hundredSidedDice = HundredSidedDice(rollD100)

                    val result =
                      RollCheckRules.characteristicCheck(
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

    describe(s"when ${Size(4)}") {
      describe("when Extreme difficulty") {
        it("should throw an RuntimeException *Impossible to succeed") {
          val rollD100 = mockFunction[(Int, Int), Int]

          val hundredSidedDice = HundredSidedDice(rollD100)

          an[RuntimeException] should be thrownBy RollCheckRules
            .characteristicCheck(characteristic)(
              hundredSidedDice
            )
        }
      }
    }
  }
}

class RollCheckRulesSpec
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
              val rollD100 = mockFunction[(Int, Int), Int]
              rollD100.expects(range).once().returning(100)

              val hundredSidedDice = HundredSidedDice(rollD100)

              val result =
                RollCheckRules.characteristicCheck(characteristic)(
                  hundredSidedDice
                )

              result shouldBe RollCheckRules.FumbleResult
            }
          }

          describe("when rolling 1") {
            it("should return Critical Success") {
              val rollD100 = mockFunction[(Int, Int), Int]
              rollD100.expects(range).once().returning(1)

              val hundredSidedDice = HundredSidedDice(rollD100)

              val result =
                RollCheckRules.characteristicCheck(characteristic)(
                  hundredSidedDice
                )

              result shouldBe RollCheckRules.CriticalSuccessResult
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
    behavesLikeRollResult(RollCheckRules.FumbleResult, false)
    behavesLikeRollResult(RollCheckRules.FailureResult, false)
    behavesLikeRollResult(RollCheckRules.SuccessResult, true)
    behavesLikeRollResult(RollCheckRules.HardSuccessResult, true)
    behavesLikeRollResult(RollCheckRules.ExtremeSuccessResult, true)
    behavesLikeRollResult(RollCheckRules.CriticalSuccessResult, true)
  }

  def behavesLikeRollResult(result: RollCheckRules.RollResult, expected: Boolean) = {
    import com.malk.coc.rules.RollCheckRules.RollResult.implicits._

    describe(s"${result}") {
      it(s"should be implicit converted to ${expected}") {
        val converted: Boolean = result

        converted shouldBe expected
      }
    }
  }
}
