package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.characteristics.Age
import com.malk.coc.helpers.Dice

trait HumanAgingOnEducationBehaviors extends Matchers with MockFactory {
  this: AnyFunSpec =>
  def humanAgingOnEducationIncrementCheck(
      age: Age,
      edu: Education,
      rolls: Seq[Int],
      increments: Seq[Int]
  ) {
    val rollsStr = rolls.mkString("(", ") - (", ")")
    val incrementsStr = increments.mkString("(", ") + (", ")")

    describe(s"when rolls are ${rollsStr}") {
      describe(s"when increments are ${incrementsStr}") {
        val total = increments.reduce(_ + _)
        val expected = edu.copy(edu.value + total)

        it(s"should return ${expected} increased by ${total}") {
          val success100 = mockFunction[Int]

          rolls.foreach(roll => success100.expects().returning(roll))

          val success10 = mockFunction[Int]

          increments.foreach(increment =>
            if (increment == 0)
              success10.expects().returning(increment).never()
            else
              success10.expects().returning(increment).once()
          )

          val hao = new HumanAgingOnEducation(success100, success10)

          hao.modifiedEducation(age, edu) shouldBe expected
        }
      }
    }
  }
}

class HumanAgingOnEducationSpec
    extends AnyFunSpec
    with HumanAgingOnEducationBehaviors {
  describe("Human aging effects on EDU") {
    val edu = Education(67)

    describe("when age is bellow 20") {
      val age = Dice.randomAge(15, 19)

      val hao = new HumanAgingOnEducation

      it("should return new Education reduced in 5") {
        hao.modifiedEducation(age, edu) shouldBe Education(67 - 5)
      }
    }

    describe("when age is between 20 and 39") {
      val age = Dice.randomAge(20, 39)

      describe("when first EDU improvement check is superior to EDU") {
        val firstImprovementCheckIsSuperior = true

        val results = singleCheckResults(firstImprovementCheckIsSuperior)

        it should behave like humanAgingOnEducationIncrementCheck(
          age,
          edu,
          results._1,
          results._2
        )
      }

      describe("when first EDU improvement check is equal or inferior to EDU") {
        val firstImprovementCheckIsSuperior = false

        val results = singleCheckResults(firstImprovementCheckIsSuperior)

        it should behave like humanAgingOnEducationIncrementCheck(
          age,
          edu,
          results._1,
          results._2
        )
      }
    }

    describe("when age is in the 40s") {
      val age = Dice.randomAge(40, 49)

      Seq(true, false).foreach(firstImprovementCheckIsSuperior => {

        describe(
          s"when first EDU improvement check is ${text(firstImprovementCheckIsSuperior)} to EDU"
        ) {

          Seq(true, false).foreach(secondImprovementCheckIsSuperior => {

            describe(
              s"and second EDU improvement check is ${text(secondImprovementCheckIsSuperior)} to EDU"
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
          })
        }
      })
    }

    describe("when age is in the 50s") {
      val age = Dice.randomAge(50, 59)

      Seq(true, false).foreach(firstImprovementCheckIsSuperior => {

        describe(
          s"when first EDU improvement check is ${text(firstImprovementCheckIsSuperior)} to EDU"
        ) {

          Seq(true, false).foreach(secondImprovementCheckIsSuperior => {

            describe(
              s"and second EDU improvement check is ${text(secondImprovementCheckIsSuperior)} to EDU"
            ) {

              Seq(true, false).foreach(thirdImprovementCheckIsSuperior => {

                describe(
                  s"and third EDU improvement check is ${text(thirdImprovementCheckIsSuperior)} to EDU"
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
              })
            }
          })
        }
      })
    }

    describe("when age is 60 or above") {
      val age = Dice.randomAge(60, 89)

      Seq(true, false).foreach(firstImprovementCheckIsSuperior => {

        describe(
          s"when first EDU improvement check is ${text(firstImprovementCheckIsSuperior)} to EDU"
        ) {

          Seq(true, false).foreach(secondImprovementCheckIsSuperior => {

            describe(
              s"and second EDU improvement check is ${text(secondImprovementCheckIsSuperior)} to EDU"
            ) {

              Seq(true, false).foreach(thirdImprovementCheckIsSuperior => {

                describe(
                  s"and third EDU improvement check is ${text(thirdImprovementCheckIsSuperior)} to EDU"
                ) {

                  Seq(true, false).foreach(fourthImprovementCheckIsSuperior => {

                    describe(
                      s"and fourth EDU improvement check is ${text(fourthImprovementCheckIsSuperior)} to EDU"
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
                  })

                }
              })
            }
          })
        }
      })
    }
  }

  val rollSuccess4 = 96
  val rollFailure4 = 34
  val increment4 = 4

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
      result._1 ++ Seq(if (success3) 93 else 11),
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
      result._1 ++ Seq(if (success3) 90 else 9),
      result._2 ++ Seq(if (success3) 4 else 0)
    )
  }

  def text(checkIsSuperior: Boolean) =
    if (checkIsSuperior) "superior"
    else "equal or inferior"
}
