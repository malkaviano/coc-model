package com.malk.coc.helpers

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.mutable
import com.malk.coc.concepts.attributes.Age
import com.malk.coc.concepts.dices.DiceRange

class DiceHelperSpec extends AnyFunSpec with Matchers {
  describe("Simulating D8 rolls") {
    it("should return a number between 1 and 8 at least once") {
      val rolls = mutable.Set.empty[Int]

      for (n <- 1 to 1000) {
        rolls.add(DiceHelper.roll8)
      }

      rolls should contain.only(1, 2, 3, 4, 5, 6, 7, 8)
    }
  }

  describe("Generating a random Age") {
    it("should return an Age between 15 and 89 at least once") {
      val ages = mutable.Set.empty[Age]

      for (n <- 1 to 1000) {
        ages.add(DiceHelper.randomAge())
      }

      ages should contain theSameElementsAs (15 to 89).map { i => Age(i) }
    }

    it("should return an Age between 20 and 39 at least once") {
      val ages = mutable.Set.empty[Age]

      for (n <- 1 to 1000) {
        ages.add(DiceHelper.randomAge(20, 39))
      }

      ages should contain theSameElementsAs (20 to 39).map { i => Age(i) }
    }
  }

  describe("Rolling a range") {
    describe("when range is (1, 6)") {
      it("should return a number between 1 and 6 at least once") {
        val rolls = mutable.Set.empty[Int]

        for (n <- 1 to 1000) {
          rolls.add(DiceHelper.rollRange(DiceRange(1, 6)))
        }

        rolls should contain.only(1, 2, 3, 4, 5, 6)
      }
    }

    describe("when range is (1, 4)") {
      it("should return a number between 1 and 4 at least once") {
        val rolls = mutable.Set.empty[Int]

        for (n <- 1 to 1000) {
          rolls.add(DiceHelper.rollRange(DiceRange(1, 4)))
        }

        rolls should contain.only(1, 2, 3, 4)
      }
    }

    describe("when range is (1, 10)") {
      it("should return a number between 1 and 10 at least once") {
        val rolls = mutable.Set.empty[Int]

        for (n <- 1 to 1000) {
          rolls.add(DiceHelper.rollRange(DiceRange(1, 10)))
        }

        rolls should contain.only(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
      }
    }

    describe("when range is (1, 100)") {
      it("should return a number between 1 and 100 at least once") {
        val rolls = mutable.Set.empty[Int]

        for (n <- 1 to 1000) {
          rolls.add(DiceHelper.rollRange(DiceRange(1, 100)))
        }

        rolls should contain theSameElementsAs (1 to 100)
      }
    }
  }
}
