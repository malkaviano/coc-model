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
        val expected = increments.reduce(_ + _)

        it(s"should return new Education increased by ${expected}") {
          val roll100 = mockFunction[Int]

          rolls.foreach(roll => roll100.expects().returning(roll))

          val roll10 = mockFunction[Int]

          increments.foreach(increment =>
            if (increment == 0)
              roll10.expects().returning(increment).never()
            else
              roll10.expects().returning(increment).once()
          )

          val hao = new HumanAgingOnEducation(roll100, roll10)

          hao.modifiedEducation(age, edu) shouldBe edu.copy(value =
            edu.value + expected
          )
        }
      }
    }
  }
}

class HumanAgingOnEducationSpec
    extends AnyFunSpec
    with Matchers
    with MockFactory
    with HumanAgingOnEducationBehaviors {
  describe("Human aging effects on EDU") {
    describe("when age is bellow 20") {
      val age = Dice.randomAge(15, 19)
      val edu = Education(67)
      val hao = new HumanAgingOnEducation

      it("should return new Education reduced in 5") {
        hao.modifiedEducation(age, edu) shouldBe Education(67 - 5)
      }
    }

    describe("when age is between 20 and 39") {
      val age = Dice.randomAge(20, 39)
      val edu = Education(67)

      describe("when first EDU improvement check is superior to EDU") {
        val roll1 = 90
        val increment1 = 5

        it should behave like humanAgingOnEducationIncrementCheck(
          age,
          edu,
          Seq(roll1),
          Seq(increment1)
        )
      }

      describe("when first EDU improvement check is equal or inferior to EDU") {
        val roll1 = 6
        val increment1 = 0

        it should behave like humanAgingOnEducationIncrementCheck(
          age,
          edu,
          Seq(roll1),
          Seq(increment1)
        )
      }
    }

    describe("when age is in the 40s") {
      val age = Dice.randomAge(40, 49)
      val edu = Education(67)

      describe("when first EDU improvement check is superior to EDU") {
        val roll1 = 90
        val increment1 = 5

        describe("and second EDU improvement check is superior to EDU") {
          val roll2 = 80
          val increment2 = 3

          it should behave like humanAgingOnEducationIncrementCheck(
            age,
            edu,
            Seq(roll1, roll2),
            Seq(increment1, increment2)
          )
        }

        describe(
          "and second EDU improvement check is equal or inferior to EDU"
        ) {
          val roll2 = 24
          val increment2 = 0

          it should behave like humanAgingOnEducationIncrementCheck(
            age,
            edu,
            Seq(roll1, roll2),
            Seq(increment1, increment2)
          )
        }
      }

      describe("when first EDU improvement check is equal or inferior to EDU") {
        val roll1 = 40
        val increment1 = 0

        describe("and second EDU improvement check is superior to EDU") {
          val roll2 = 80
          val increment2 = 3

          it should behave like humanAgingOnEducationIncrementCheck(
            age,
            edu,
            Seq(roll1, roll2),
            Seq(increment1, increment2)
          )
        }

        describe(
          "and second EDU improvement check is equal or inferior to EDU"
        ) {
          val roll2 = 24
          val increment2 = 0

          it should behave like humanAgingOnEducationIncrementCheck(
            age,
            edu,
            Seq(roll1, roll2),
            Seq(increment1, increment2)
          )
        }
      }
    }

    describe("when age is in the 50s") {
      val age = Dice.randomAge(50, 59)
      val edu = Education(67)

      describe("when first EDU improvement check is superior to EDU") {
        val roll1 = 80
        val increment1 = 5

        describe("and second EDU improvement check is superior to EDU") {
          val roll2 = 85
          val increment2 = 3

          describe("and third EDU improvement check is superior to EDU") {
            val roll3 = 90
            val increment3 = 7

            it should behave like humanAgingOnEducationIncrementCheck(
              age,
              edu,
              Seq(roll1, roll2, roll3),
              Seq(increment1, increment2, increment3)
            )
          }

          describe(
            "and third EDU improvement check is equal or inferior to EDU"
          ) {
            val roll3 = 10
            val increment3 = 0

            it should behave like humanAgingOnEducationIncrementCheck(
              age,
              edu,
              Seq(roll1, roll2, roll3),
              Seq(increment1, increment2, increment3)
            )
          }
        }

        describe(
          "and second EDU improvement check is equal or inferior to EDU"
        ) {
          val roll2 = 20
          val increment2 = 0

          describe("and third EDU improvement check is superior to EDU") {
            val roll3 = 90
            val increment3 = 7

            it should behave like humanAgingOnEducationIncrementCheck(
              age,
              edu,
              Seq(roll1, roll2, roll3),
              Seq(increment1, increment2, increment3)
            )
          }

          describe(
            "and third EDU improvement check is equal or inferior to EDU"
          ) {
            val roll3 = 10
            val increment3 = 0

            it should behave like humanAgingOnEducationIncrementCheck(
              age,
              edu,
              Seq(roll1, roll2, roll3),
              Seq(increment1, increment2, increment3)
            )
          }
        }
      }

      describe("when first EDU improvement check is equal or inferior to EDU") {
        val roll1 = 20
        val increment1 = 0

        describe("and second EDU improvement check is superior to EDU") {
          val roll2 = 85
          val increment2 = 3

          describe("and third EDU improvement check is superior to EDU") {
            val roll3 = 90
            val increment3 = 7

            it should behave like humanAgingOnEducationIncrementCheck(
              age,
              edu,
              Seq(roll1, roll2, roll3),
              Seq(increment1, increment2, increment3)
            )
          }

          describe(
            "and third EDU improvement check is equal or inferior to EDU"
          ) {
            val roll3 = 10
            val increment3 = 0

            it should behave like humanAgingOnEducationIncrementCheck(
              age,
              edu,
              Seq(roll1, roll2, roll3),
              Seq(increment1, increment2, increment3)
            )
          }
        }

        describe(
          "and second EDU improvement check is equal or inferior to EDU"
        ) {
          val roll2 = 20
          val increment2 = 0

          describe("and third EDU improvement check is superior to EDU") {
            val roll3 = 90
            val increment3 = 7

            it should behave like humanAgingOnEducationIncrementCheck(
              age,
              edu,
              Seq(roll1, roll2, roll3),
              Seq(increment1, increment2, increment3)
            )
          }

          describe(
            "and third EDU improvement check is equal or inferior to EDU"
          ) {
            val roll3 = 10
            val increment3 = 0

            it should behave like humanAgingOnEducationIncrementCheck(
              age,
              edu,
              Seq(roll1, roll2, roll3),
              Seq(increment1, increment2, increment3)
            )
          }
        }
      }
    }

    describe("when age is 60 or above") {
      val age = Dice.randomAge(60, 89)
      val edu = Education(67)

      describe("when first EDU improvement check is superior to EDU") {
        val roll1 = 80
        val increment1 = 5

        describe("and second EDU improvement check is superior to EDU") {
          val roll2 = 85
          val increment2 = 3

          describe("and third EDU improvement check is superior to EDU") {
            val roll3 = 90
            val increment3 = 7

            describe("and forth EDU improvement check is superior to EDU") {
              val roll4 = 96
              val increment4 = 4

              it should behave like humanAgingOnEducationIncrementCheck(
                age,
                edu,
                Seq(roll1, roll2, roll3, roll4),
                Seq(increment1, increment2, increment3, increment4)
              )
            }

            describe(
              "and forth EDU improvement check is equal or inferior to EDU"
            ) {
              val roll4 = 26
              val increment4 = 0

              it should behave like humanAgingOnEducationIncrementCheck(
                age,
                edu,
                Seq(roll1, roll2, roll3, roll4),
                Seq(increment1, increment2, increment3, increment4)
              )
            }
          }

          describe(
            "and third EDU improvement check is equal or inferior to EDU"
          ) {
            val roll3 = 34
            val increment3 = 0

            describe("and forth EDU improvement check is superior to EDU") {
              val roll4 = 96
              val increment4 = 4

              it should behave like humanAgingOnEducationIncrementCheck(
                age,
                edu,
                Seq(roll1, roll2, roll3, roll4),
                Seq(increment1, increment2, increment3, increment4)
              )
            }

            describe(
              "and forth EDU improvement check is equal or inferior to EDU"
            ) {
              val roll4 = 26
              val increment4 = 0

              it should behave like humanAgingOnEducationIncrementCheck(
                age,
                edu,
                Seq(roll1, roll2, roll3, roll4),
                Seq(increment1, increment2, increment3, increment4)
              )
            }
          }
        }

        describe(
          "and second EDU improvement check is equal or inferior to EDU"
        ) {
          val roll2 = 17
          val increment2 = 0

          describe("and third EDU improvement check is superior to EDU") {
            val roll3 = 90
            val increment3 = 7

            describe("and forth EDU improvement check is superior to EDU") {
              val roll4 = 96
              val increment4 = 4

              it should behave like humanAgingOnEducationIncrementCheck(
                age,
                edu,
                Seq(roll1, roll2, roll3, roll4),
                Seq(increment1, increment2, increment3, increment4)
              )
            }

            describe(
              "and forth EDU improvement check is equal or inferior to EDU"
            ) {
              val roll4 = 26
              val increment4 = 0

              it should behave like humanAgingOnEducationIncrementCheck(
                age,
                edu,
                Seq(roll1, roll2, roll3, roll4),
                Seq(increment1, increment2, increment3, increment4)
              )
            }
          }

          describe(
            "and third EDU improvement check is equal or inferior to EDU"
          ) {
            val roll3 = 34
            val increment3 = 0

            describe("and forth EDU improvement check is superior to EDU") {
              val roll4 = 96
              val increment4 = 4

              it should behave like humanAgingOnEducationIncrementCheck(
                age,
                edu,
                Seq(roll1, roll2, roll3, roll4),
                Seq(increment1, increment2, increment3, increment4)
              )
            }

            describe(
              "and forth EDU improvement check is equal or inferior to EDU"
            ) {
              val roll4 = 26
              val increment4 = 0

              it should behave like humanAgingOnEducationIncrementCheck(
                age,
                edu,
                Seq(roll1, roll2, roll3, roll4),
                Seq(increment1, increment2, increment3, increment4)
              )
            }
          }
        }
      }

      describe("when first EDU improvement check is equal or inferior to EDU") {
        val roll1 = 9
        val increment1 = 0

        describe("and second EDU improvement check is superior to EDU") {
          val roll2 = 85
          val increment2 = 3

          describe("and third EDU improvement check is superior to EDU") {
            val roll3 = 90
            val increment3 = 7

            describe("and forth EDU improvement check is superior to EDU") {
              val roll4 = 96
              val increment4 = 4

              it should behave like humanAgingOnEducationIncrementCheck(
                age,
                edu,
                Seq(roll1, roll2, roll3, roll4),
                Seq(increment1, increment2, increment3, increment4)
              )
            }

            describe(
              "and forth EDU improvement check is equal or inferior to EDU"
            ) {
              val roll4 = 26
              val increment4 = 0

              it should behave like humanAgingOnEducationIncrementCheck(
                age,
                edu,
                Seq(roll1, roll2, roll3, roll4),
                Seq(increment1, increment2, increment3, increment4)
              )
            }
          }

          describe(
            "and third EDU improvement check is equal or inferior to EDU"
          ) {
            val roll3 = 34
            val increment3 = 0

            describe("and forth EDU improvement check is superior to EDU") {
              val roll4 = 96
              val increment4 = 4

              it should behave like humanAgingOnEducationIncrementCheck(
                age,
                edu,
                Seq(roll1, roll2, roll3, roll4),
                Seq(increment1, increment2, increment3, increment4)
              )
            }

            describe(
              "and forth EDU improvement check is equal or inferior to EDU"
            ) {
              val roll4 = 26
              val increment4 = 0

              it should behave like humanAgingOnEducationIncrementCheck(
                age,
                edu,
                Seq(roll1, roll2, roll3, roll4),
                Seq(increment1, increment2, increment3, increment4)
              )
            }
          }
        }

        describe(
          "and second EDU improvement check is equal or inferior to EDU"
        ) {
          val roll2 = 17
          val increment2 = 0

          describe("and third EDU improvement check is superior to EDU") {
            val roll3 = 90
            val increment3 = 7

            describe("and forth EDU improvement check is superior to EDU") {
              val roll4 = 96
              val increment4 = 4

              it should behave like humanAgingOnEducationIncrementCheck(
                age,
                edu,
                Seq(roll1, roll2, roll3, roll4),
                Seq(increment1, increment2, increment3, increment4)
              )
            }

            describe(
              "and forth EDU improvement check is equal or inferior to EDU"
            ) {
              val roll4 = 26
              val increment4 = 0

              it should behave like humanAgingOnEducationIncrementCheck(
                age,
                edu,
                Seq(roll1, roll2, roll3, roll4),
                Seq(increment1, increment2, increment3, increment4)
              )
            }
          }

          describe(
            "and third EDU improvement check is equal or inferior to EDU"
          ) {
            val roll3 = 34
            val increment3 = 0

            describe("and forth EDU improvement check is superior to EDU") {
              val roll4 = 96
              val increment4 = 4

              it should behave like humanAgingOnEducationIncrementCheck(
                age,
                edu,
                Seq(roll1, roll2, roll3, roll4),
                Seq(increment1, increment2, increment3, increment4)
              )
            }

            describe(
              "and forth EDU improvement check is equal or inferior to EDU"
            ) {
              val roll4 = 26
              val increment4 = 0

              it should behave like humanAgingOnEducationIncrementCheck(
                age,
                edu,
                Seq(roll1, roll2, roll3, roll4),
                Seq(increment1, increment2, increment3, increment4)
              )
            }
          }
        }
      }
    }
  }
}
