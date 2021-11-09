package com.malk.coc.rules

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalamock.scalatest.MockFactory

import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.characteristics.Age
import com.malk.coc.helpers.Dice

class HumanAgingOnEducationSpec
    extends AnyFunSpec
    with Matchers
    with MockFactory {
  describe("Human aging effects on EDU") {
    describe("when age is bellow 20") {
      val age = Dice.randomAge(15, 19)
      val edu = Education(67)
      val hao = new HumanAgingOnEducation(age, edu)

      it("should return new Education reduced in 5") {
        hao.modifiedEducation shouldBe Education(67 - 5)
      }
    }

    describe("when age is between 20 and 39") {
      val age = Dice.randomAge(20, 39)
      val edu = Education(67)

      describe("when EDU check passes") {
        it("should return new Education increased (5)") {
          val roll100 = mockFunction[Int]

          roll100.expects().returning(90).once()

          val roll10 = mockFunction[Int]

          roll10.expects().returning(5).once()

          val hao = new HumanAgingOnEducation(age, edu, roll100, roll10)

          hao.modifiedEducation shouldBe Education(67 + 5)
        }
      }

      describe("when EDU check fails") {
        it("should return same Education") {
          val roll100 = mockFunction[Int]

          roll100.expects().returning(40).once()

          val roll10 = mockFunction[Int]

          roll10.expects().returning(5).never()

          val hao = new HumanAgingOnEducation(age, edu, roll100, roll10)

          hao.modifiedEducation shouldBe Education(67)
        }
      }
    }

    describe("when age is in the 40s") {
      val age = Dice.randomAge(40, 49)
      val edu = Education(67)

      describe("when first EDU check passes") {
        describe("and second EDU check passes") {
          it("should return new Education increased (5) + (3)") {
            val roll100 = mockFunction[Int]

            roll100.expects().returning(90).once()
            roll100.expects().returning(80).once()

            val roll10 = mockFunction[Int]

            roll10.expects().returning(5).once()
            roll10.expects().returning(3).once()

            val hao = new HumanAgingOnEducation(age, edu, roll100, roll10)

            hao.modifiedEducation shouldBe Education(67 + 5 + 3)
          }
        }

        describe("and second EDU check fails") {
          it("should return new Education increased (5)") {
            val roll100 = mockFunction[Int]

            roll100.expects().returning(90).once()
            roll100.expects().returning(40).once()

            val roll10 = mockFunction[Int]

            roll10.expects().returning(5).once()
            roll10.expects().returning(3).never()

            val hao = new HumanAgingOnEducation(age, edu, roll100, roll10)

            hao.modifiedEducation shouldBe Education(67 + 5)
          }
        }
      }

      describe("when first EDU check fails") {
        describe("and second EDU check passes") {
          it("should return new Education increased (3)") {
            val roll100 = mockFunction[Int]

            roll100.expects().returning(40).once()
            roll100.expects().returning(90).once()

            val roll10 = mockFunction[Int]

            roll10.expects().returning(3).once()
            roll10.expects().returning(5).never()

            val hao = new HumanAgingOnEducation(age, edu, roll100, roll10)

            hao.modifiedEducation shouldBe Education(70)
          }
        }

        describe("and second EDU check fails") {
          it("should return same Education") {
            val roll100 = mockFunction[Int]

            roll100.expects().returning(40).once()
            roll100.expects().returning(30).once()

            val roll10 = mockFunction[Int]

            roll10.expects().returning(3).never()
            roll10.expects().returning(5).never()

            val hao = new HumanAgingOnEducation(age, edu, roll100, roll10)

            hao.modifiedEducation shouldBe Education(67)
          }
        }
      }
    }

    describe("when age is in the 50s or above") {
      val age = Dice.randomAge(50, 59)
      val edu = Education(67)

      describe("when first EDU check passes") {
        describe("and second EDU check passes") {
          describe("and third EDU check passes") {
            it("should return new Education increased (5) + (3) + (7)") {
              val roll100 = mockFunction[Int]

              roll100.expects().returning(80).once()
              roll100.expects().returning(85).once()
              roll100.expects().returning(90).once()

              val roll10 = mockFunction[Int]

              roll10.expects().returning(5).once()
              roll10.expects().returning(3).once()
              roll10.expects().returning(7).once()

              val hao = new HumanAgingOnEducation(age, edu, roll100, roll10)

              hao.modifiedEducation shouldBe Education(67 + 5 + 3 + 7)
            }
          }

          describe("and third EDU check fails") {
            it("should return new Education increased (5) + (3) + (0)") {
              val roll100 = mockFunction[Int]

              roll100.expects().returning(80).once()
              roll100.expects().returning(85).once()
              roll100.expects().returning(10).once()

              val roll10 = mockFunction[Int]

              roll10.expects().returning(5).once()
              roll10.expects().returning(3).once()
              roll10.expects().returning(7).never()

              val hao = new HumanAgingOnEducation(age, edu, roll100, roll10)

              hao.modifiedEducation shouldBe Education(67 + 5 + 3)
            }
          }
        }

        describe("and second EDU check fails") {
          describe("and third EDU check passes") {
            it("should return new Education increased (5) + (0) + (7)") {
              val roll100 = mockFunction[Int]

              roll100.expects().returning(80).once()
              roll100.expects().returning(20).once()
              roll100.expects().returning(90).once()

              val roll10 = mockFunction[Int]

              roll10.expects().returning(5).once()
              roll10.expects().returning(3).never()
              roll10.expects().returning(7).once()

              val hao = new HumanAgingOnEducation(age, edu, roll100, roll10)

              hao.modifiedEducation shouldBe Education(67 + 5 + 7)
            }
          }

          describe("and third EDU check fails") {
            it("should return new Education increased (5) + (0) + (0)") {
              val roll100 = mockFunction[Int]

              roll100.expects().returning(80).once()
              roll100.expects().returning(20).once()
              roll100.expects().returning(10).once()

              val roll10 = mockFunction[Int]

              roll10.expects().returning(5).once()
              roll10.expects().returning(3).never()
              roll10.expects().returning(7).never()

              val hao = new HumanAgingOnEducation(age, edu, roll100, roll10)

              hao.modifiedEducation shouldBe Education(67 + 5)
            }
          }
        }
      }

      describe("when first EDU check fails") {
        describe("and second EDU check passes") {
          describe("and third EDU check passes") {
            it("should return new Education increased (0) + (3) + (7)") {
              val roll100 = mockFunction[Int]

              roll100.expects().returning(30).once()
              roll100.expects().returning(85).once()
              roll100.expects().returning(90).once()

              val roll10 = mockFunction[Int]

              roll10.expects().returning(5).never()
              roll10.expects().returning(3).once()
              roll10.expects().returning(7).once()

              val hao = new HumanAgingOnEducation(age, edu, roll100, roll10)

              hao.modifiedEducation shouldBe Education(67 + 3 + 7)
            }
          }

          describe("and third EDU check fails") {
            it("should return new Education increased (0) + (3) + (0)") {
              val roll100 = mockFunction[Int]

              roll100.expects().returning(30).once()
              roll100.expects().returning(85).once()
              roll100.expects().returning(10).once()

              val roll10 = mockFunction[Int]

              roll10.expects().returning(5).never()
              roll10.expects().returning(3).once()
              roll10.expects().returning(7).never()

              val hao = new HumanAgingOnEducation(age, edu, roll100, roll10)

              hao.modifiedEducation shouldBe Education(67 + 3)
            }
          }
        }

        describe("and second EDU check fails") {
          describe("and third EDU check passes") {
            it("should return new Education increased (0) + (0) + (7)") {
              val roll100 = mockFunction[Int]

              roll100.expects().returning(30).once()
              roll100.expects().returning(20).once()
              roll100.expects().returning(90).once()

              val roll10 = mockFunction[Int]

              roll10.expects().returning(5).never()
              roll10.expects().returning(3).never()
              roll10.expects().returning(7).once()

              val hao = new HumanAgingOnEducation(age, edu, roll100, roll10)

              hao.modifiedEducation shouldBe Education(67 + 7)
            }
          }

          describe("and third EDU check fails") {
            it("should return same Education") {
              val roll100 = mockFunction[Int]

              roll100.expects().returning(30).once()
              roll100.expects().returning(20).once()
              roll100.expects().returning(10).once()

              val roll10 = mockFunction[Int]

              roll10.expects().returning(5).never()
              roll10.expects().returning(3).never()
              roll10.expects().returning(7).never()

              val hao = new HumanAgingOnEducation(age, edu, roll100, roll10)

              hao.modifiedEducation shouldBe Education(67)
            }
          }
        }
      }
    }
  }
}
