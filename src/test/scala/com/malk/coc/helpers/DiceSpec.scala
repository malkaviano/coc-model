package com.malk.coc.helpers

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.mutable
import com.malk.coc.concepts.characteristics.Age

class DiceSpec extends AnyFunSpec with Matchers {
  describe("Simulating D10 rolls") {
    it("should return a number between 1 and 10 at least once") {
      val rolls = mutable.Set.empty[Int]

      for(n <- 1 to 1000) {
        rolls.add(DiceHelper.roll10)
      }

      rolls should contain.only (1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }
  }

  describe("Simulating D8 rolls") {
    it("should return a number between 1 and 8 at least once") {
      val rolls = mutable.Set.empty[Int]

      for(n <- 1 to 1000) {
        rolls.add(DiceHelper.roll8)
      }

      rolls should contain.only (1, 2, 3, 4, 5, 6, 7, 8)
    }
  }

  describe("Simulating D6 rolls") {
    it("should return a number between 1 and 6 at least once") {
      val rolls = mutable.Set.empty[Int]

      for(n <- 1 to 1000) {
        rolls.add(DiceHelper.roll6)
      }

      rolls should contain.only (1, 2, 3, 4, 5, 6)
    }
  }

  describe("Simulating D4 rolls") {
    it("should return a number between 1 and 4 at least once") {
      val rolls = mutable.Set.empty[Int]

      for(n <- 1 to 1000) {
        rolls.add(DiceHelper.roll4)
      }

      rolls should contain.only (1, 2, 3, 4)
    }
  }

  describe("Simulating D100 rolls") {
    it("should return a number between 1 and 100 at least once") {
      val rolls = mutable.Set.empty[Int]

      for(n <- 1 to 1000) {
        rolls.add(DiceHelper.roll100)
      }

      rolls should contain theSameElementsAs (1 to 100)
    }
  }

  describe("Generating a random Age") {
    it("should return an Age between 15 and 89 at least once") {
      val ages = mutable.Set.empty[Age]

      for(n <- 1 to 1000) {
        ages.add(DiceHelper.randomAge())
      }

      ages should contain theSameElementsAs (15 to 89).map { i => Age(i) }
    }

    it("should return an Age between 20 and 39 at least once") {
      val ages = mutable.Set.empty[Age]

      for(n <- 1 to 1000) {
        ages.add(DiceHelper.randomAge(20, 39))
      }

      ages should contain theSameElementsAs (20 to 39).map { i => Age(i) }
    }
  }
}