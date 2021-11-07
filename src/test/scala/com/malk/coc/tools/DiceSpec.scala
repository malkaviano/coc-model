package com.malk.coc.tools

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.mutable

class ConceptSpec extends AnyFunSpec with Matchers {
  describe("Simulating one hundred D10 rolls") {
    it("should always return a number between 1 and 10") {
      val rolls = mutable.Set.empty[Int]

      for(n <- 1 to 1000) {
        rolls.add(Dice.roll10)
      }

      rolls should contain only (1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }
  }
}