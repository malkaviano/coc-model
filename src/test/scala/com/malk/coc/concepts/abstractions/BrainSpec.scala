package com.malk.coc.concepts.abstractions

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import com.malk.coc.concepts.characteristics.Intelligence
import com.malk.coc.concepts.characteristics.Power

class BrainSpec extends AnyFunSpec with Matchers {

  describe("External abstraction Brain") {
    val int = Intelligence(50)
    val pow = Power(60)

    val brain = Brain(int, pow)

    it(s"should have ${int}") {
      brain.intelligence shouldBe int
    }

    it(s"should have ${pow}") {
      brain.power shouldBe pow
    }
  }
}
