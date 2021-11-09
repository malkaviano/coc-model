package com.malk.coc.helpers

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.mutable

class DiceSpec extends AnyFunSpec with Matchers {
  describe("Simulating D10 rolls") {
    it("should return a number between 1 and 10 at least once") {
      val rolls = mutable.Set.empty[Int]

      for(n <- 1 to 1000) {
        rolls.add(Dice.roll10)
      }

      rolls should contain only (1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }
  }

  describe("Simulating D8 rolls") {
    it("should return a number between 1 and 8 at least once") {
      val rolls = mutable.Set.empty[Int]

      for(n <- 1 to 1000) {
        rolls.add(Dice.roll8)
      }

      rolls should contain only (1, 2, 3, 4, 5, 6, 7, 8)
    }
  }

  describe("Simulating D6 rolls") {
    it("should return a number between 1 and 6 at least once") {
      val rolls = mutable.Set.empty[Int]

      for(n <- 1 to 1000) {
        rolls.add(Dice.roll6)
      }

      rolls should contain only (1, 2, 3, 4, 5, 6)
    }
  }

  describe("Simulating D4 rolls") {
    it("should return a number between 1 and 4 at least once") {
      val rolls = mutable.Set.empty[Int]

      for(n <- 1 to 1000) {
        rolls.add(Dice.roll4)
      }

      rolls should contain only (1, 2, 3, 4)
    }
  }

  describe("Simulating D100 rolls") {
    it("should return a number between 1 and 100 at least once") {
      val rolls = mutable.Set.empty[Int]

      for(n <- 1 to 1000) {
        rolls.add(Dice.roll100)
      }

      rolls should contain theSameElementsAs (1 to 100)
    }
  }
}