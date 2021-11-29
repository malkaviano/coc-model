package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.helpers.DiceHelper
import com.malk.coc.abstractions.dices.TenSidedDice
import com.malk.coc.abstractions.dices.HundredSidedDice
import com.malk.coc.concepts.attributes.Age

import com.malk.coc.helpers.CharacteristicModifications.implicits._
import com.malk.coc.abstractions.dices.SixSidedDice
import com.malk.coc.abstractions.dices.FourSidedDice
import com.malk.coc.abstractions.dices.DiceRange

trait HumanAgingOnEducationBehavior extends Matchers with MockFactory {
  this: AnyFunSpec =>
  def humanAgingOnEducationIncrementCheck(
      age: Age,
      edu: Education,
      rolls: Seq[Int],
      increments: Seq[Int]
  ): Unit = {
    val rollsStr = rolls.mkString("(", ") - (", ")")
    val incrementsStr = increments.mkString("(", ") + (", ")")

    describe(s"the chance rolls: ${rollsStr}") {
      describe(s"the increment rolls: ${incrementsStr}") {
        val total = increments.reduce(_ + _)
        val temp = edu + total
        val expected = if (temp.value > 99) Education(99)  else temp

        it(s"should return ${expected}. Rolled increments: ${total}") {
          val success100 = mockFunction[DiceRange, Int]

          rolls.foreach(roll => success100.expects(DiceRange(1, 100)).returning(roll))

          val success10 = mockFunction[DiceRange, Int]

          increments.foreach(increment =>
            if (increment != 0) {
              success10.expects(DiceRange(1, 10)).once().returning(increment)
            }
          )

          val fourSidedDice = FourSidedDice((t: DiceRange) => 3)
          val sixSidedDice = SixSidedDice((t: DiceRange) => 5)

          val humanAgingRules = new HumanAgingRules(age)(
            fourSidedDice,
            sixSidedDice,
            TenSidedDice(success10),
            HundredSidedDice(success100)
          )

          val result = humanAgingRules on edu

          result shouldBe expected
        }
      }
    }
  }
}

class HumanAgingRulesOnEducationSpec
    extends AnyFunSpec
    with Matchers
    with HumanAgingOnEducationBehavior {
  val edu = Education(67)

  val fourSidedDice = FourSidedDice((t: DiceRange) => 3)
  val sixSidedDice = SixSidedDice((t: DiceRange) => 5)
  val tenSidedDice = TenSidedDice((t: DiceRange) => 9)
  val hundredSidedDice = HundredSidedDice((t: DiceRange) => 100)

  describe(s"Human Aging on ${edu}") {
    describe("when age is bellow 20") {
      val age = DiceHelper.randomAge(15, 19)

      val humanAgingRules = new HumanAgingRules(age)(
        fourSidedDice,
        sixSidedDice,
        tenSidedDice,
        hundredSidedDice
      )

      val expected = edu - 5

      it(s"should return ${expected} was reduced by 5") {
        val result = humanAgingRules on edu

        result shouldBe expected
      }
    }

    describe(
      "when age is between 20 and 39 a single improvement check is made"
    ) {
      val age = DiceHelper.randomAge(20, 39)

      Seq(true, false).foreach(firstImprovementCheckIsSuperior => {

        describe(
          s"when first EDU improvement check is ${text(firstImprovementCheckIsSuperior)} to EDU"
        ) {

          val results = singleCheckResults(firstImprovementCheckIsSuperior)

          it should behave like humanAgingOnEducationIncrementCheck(
            age,
            edu,
            results._1,
            results._2
          )

          describe(
            "when age is in the 40s a second improvement check is made"
          ) {
            val age = DiceHelper.randomAge(40, 49)

            Seq(true, false).foreach(secondImprovementCheckIsSuperior => {

              describe(
                s"when second EDU improvement check is ${text(secondImprovementCheckIsSuperior)} to EDU"
              ) {
                val results = doubleCheckResults(
                  firstImprovementCheckIsSuperior,
                  secondImprovementCheckIsSuperior
                )

                it should behave like humanAgingOnEducationIncrementCheck(
                  age,
                  edu,
                  results._1,
                  results._2
                )
              }

              describe(
                "when age is in the 50s a third improvement check is made"
              ) {
                val age = DiceHelper.randomAge(50, 59)

                Seq(true, false).foreach(thirdImprovementCheckIsSuperior => {

                  describe(
                    s"when third EDU improvement check is ${text(thirdImprovementCheckIsSuperior)} to EDU"
                  ) {
                    val results = tripleCheckResults(
                      firstImprovementCheckIsSuperior,
                      secondImprovementCheckIsSuperior,
                      thirdImprovementCheckIsSuperior
                    )

                    it should behave like humanAgingOnEducationIncrementCheck(
                      age,
                      edu,
                      results._1,
                      results._2
                    )
                  }

                  describe(
                    "when age is 60 or above a fourth improvement check is made"
                  ) {
                    val age = DiceHelper.randomAge(60, 89)

                    Seq(true, false).foreach(
                      fourthImprovementCheckIsSuperior => {

                        describe(
                          s"when fourth EDU improvement check is ${text(fourthImprovementCheckIsSuperior)} to EDU"
                        ) {
                          val results = quadrupleCheckResults(
                            firstImprovementCheckIsSuperior,
                            secondImprovementCheckIsSuperior,
                            thirdImprovementCheckIsSuperior,
                            fourthImprovementCheckIsSuperior
                          )

                          it should behave like humanAgingOnEducationIncrementCheck(
                            age,
                            edu,
                            results._1,
                            results._2
                          )
                        }
                      }
                    )
                  }
                })
              }
            })
          }
        }
      })
    }

    describe("when improvement check generates Edu over 99") {
      val age = Age(82)
      val edu = Education(90)

      val results = quadrupleCheckResults(
        true,
        true,
        true,
        true
      )

      it should behave like humanAgingOnEducationIncrementCheck(
        age,
        edu,
        results._1,
        results._2
      )
    }
  }

  private def singleCheckResults(success1: Boolean): (Seq[Int], Seq[Int]) = {
    (
      Seq(if (success1) 100 else 9),
      Seq(if (success1) 5 else 0)
    )
  }

  private def doubleCheckResults(
      success1: Boolean,
      success2: Boolean
  ): (Seq[Int], Seq[Int]) = {
    val result = singleCheckResults(success1)

    (
      result._1 ++ Seq(if (success2) 100 else 19),
      result._2 ++ Seq(if (success2) 3 else 0)
    )
  }

  private def tripleCheckResults(
      success1: Boolean,
      success2: Boolean,
      success3: Boolean
  ): (Seq[Int], Seq[Int]) = {
    val result = doubleCheckResults(success1, success2)

    (
      result._1 ++ Seq(if (success3) 100 else 11),
      result._2 ++ Seq(if (success3) 7 else 0)
    )
  }

  private def quadrupleCheckResults(
      success1: Boolean,
      success2: Boolean,
      success3: Boolean,
      success4: Boolean
  ): (Seq[Int], Seq[Int]) = {
    val result = tripleCheckResults(success1, success2, success3)

    (
      result._1 ++ Seq(if (success4) 100 else 34),
      result._2 ++ Seq(if (success4) 4 else 0)
    )
  }

  def text(checkIsSuperior: Boolean) =
    if (checkIsSuperior) "superior"
    else "equal or inferior"
}
