package com.malk.coc.traits

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class AgeableSpec extends AnyFunSpec with Matchers {
  val ageable = new Ageable {
    def Age: Int = 34
  }

  it("should have Age value") {
    ageable.Age shouldBe 34
  }
}