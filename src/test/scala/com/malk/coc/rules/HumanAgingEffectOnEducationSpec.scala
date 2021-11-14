package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.characteristics.Age
import com.malk.coc.helpers.DiceHelper
import com.malk.coc.concepts.dices.DeltohedronDice

trait HumanAgingEffectOnEducationBehaviors extends Matchers with MockFactory {
  this: AnyFunSpec =>
  def humanAgingOnEducationIncrementCheck(
      age: Age,
      edu: Education,
      rolls: Seq[Int],
      increments: Seq[Int],
      deltohedronDice: DeltohedronDice
  ): Unit = {
    val rollsStr = rolls.mkString("(", ") - (", ")")
    val incrementsStr = increments.mkString("(", ") + (", ")")

    describe(s"the chance rolls: ${rollsStr}") {
      describe(s"the increment rolls: ${incrementsStr}") {
        val total = increments.reduce(_ + _)
        val expected = edu.copy(edu.value + total)

        it(s"should return ${expected}: was increased by ${total}") {
          val success100 = mockFunction[Int]

          rolls.foreach(roll => success100.expects().returning(roll))

          val hao = new HumanAgingEffectOnEducation(success100, deltohedronDice)

          hao.modifiedEducation(age, edu) shouldBe expected
        }
      }
    }
  }
}

class HumanAgingEffectOnEducationSpec
    extends AnyFunSpec
    with HumanAgingEffectOnEducationBehaviors {
  val edu = Education(67)

  val deltohedronDice = DeltohedronDice((t: (Int, Int)) => 5)

  describe(s"Human aging effects on ${edu}") {
    describe("when age is bellow 20") {
      val age = DiceHelper.randomAge(15, 19)

      val hao = new HumanAgingEffectOnEducation(() => 100, deltohedronDice)

      val expected = Education(67 - 5)

      it(s"should return ${expected} was reduced by 5") {
        hao.modifiedEducation(age, edu) shouldBe expected
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
            results._2,
            deltohedronDice
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
                  results._2,
                  deltohedronDice
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
                      results._2,
                      deltohedronDice
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
                            results._2,
                            deltohedronDice
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

    describe("when Education passes 99") {
      val edu = Education(90)
      val expected = Education(99)

      it(s"should return ${expected}") {
        val hao = new HumanAgingEffectOnEducation(() => 99, deltohedronDice)

        val result = hao.modifiedEducation(DiceHelper.randomAge(80, 89), edu)

        result shouldBe expected
      }
    }
  }

  private def singleCheckResults(success1: Boolean): (Seq[Int], Seq[Int]) = {
    (
      Seq(if (success1) 90 else 9),
      Seq(if (success1) 5 else 0)
    )
  }

  private def doubleCheckResults(
      success1: Boolean,
      success2: Boolean
  ): (Seq[Int], Seq[Int]) = {
    val result = singleCheckResults(success1)

    (
      result._1 ++ Seq(if (success2) 85 else 19),
      result._2 ++ Seq(if (success2) 5 else 0)
    )
  }

  private def tripleCheckResults(
      success1: Boolean,
      success2: Boolean,
      success3: Boolean
  ): (Seq[Int], Seq[Int]) = {
    val result = doubleCheckResults(success1, success2)

    (
      result._1 ++ Seq(if (success3) 93 else 11),
      result._2 ++ Seq(if (success3) 5 else 0)
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
      result._1 ++ Seq(if (success4) 96 else 34),
      result._2 ++ Seq(if (success4) 5 else 0)
    )
  }

  def text(checkIsSuperior: Boolean) =
    if (checkIsSuperior) "superior"
    else "equal or inferior"
}
