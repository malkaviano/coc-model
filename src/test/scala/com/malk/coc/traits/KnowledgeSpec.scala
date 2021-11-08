package com.malk.coc.traits

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.Age
import com.malk.coc.traits.EducationImprovement._

class KnowledgeSpec extends AnyFunSpec with Matchers {
  val edu = new Knowledge {
    override def EDU: Int = 76
  }

  it("should have EDU value") {
    edu.EDU shouldBe 76
  }

  describe("EDU improvement") {
    import scala.collection.mutable

    describe("when Human Age is between 20 and 39") {
      it("should return improvement 0") {
        val results = mutable.Set.empty[Int]

        for (n <- 1 to 1000) {
          results add eduImprover(Age(34))
        }

        results should contain only (0)
      }
    }

    describe("when Human Age is bellow 20") {
      it("should return improvement -1D10") {
        val results = mutable.Set.empty[Int]

        for (n <- 1 to 1000) {
          results add eduImprover(Age(18))
        }

        results should contain only (-1, -2, -3, -4, -5, -6, -7, -8, -9, -10)
      }
    }

    describe("when Human Age is in the 40's") {
      it("should return improvement +1D10") {
        val results = mutable.Set.empty[Int]

        for (n <- 1 to 1000) {
          results add eduImprover(Age(48))
        }

        results should contain only (1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
      }
    }

    describe("when Human Age is in the 50's") {
      it("should return improvement +2D10") {
        val results = mutable.Set.empty[Int]

        for (n <- 1 to 1000) {
          results add eduImprover(Age(52))
        }

        results should contain theSameElementsAs (2 to 20)
      }
    }

    describe("when Human Age is in the 60's") {
      it("should return improvement +3D10") {
        val results = mutable.Set.empty[Int]

        for (n <- 1 to 10000) {
          results add eduImprover(Age(64))
        }

        results should contain theSameElementsAs (3 to 30)
      }
    }

    describe("when Human Age is in the 70's") {
      it("should return improvement +4D10") {
        val results = mutable.Set.empty[Int]

        for (n <- 1 to 100000) {
          results add eduImprover(Age(75))
        }

        results should contain theSameElementsAs (4 to 40)
      }
    }

    describe("when Human Age is in the 80's") {
      it("should return improvement +5D10") {
        val results = mutable.Set.empty[Int]

        for (n <- 1 to 500000) {
          results add eduImprover(Age(80))
        }

        results should contain theSameElementsAs (5 to 50)
      }
    }
  }
}
