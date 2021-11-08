package com.malk.coc.traits

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class CharismaticSpec extends AnyFunSpec with Matchers {
  val charisma = new Charismatic {
    override def APP: Int = 90
  }

  it("should have APP (Appearance) value") {
    charisma.APP shouldBe 90
  }
}