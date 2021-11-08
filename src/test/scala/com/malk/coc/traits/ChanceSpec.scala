package com.malk.coc.traits

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class ChanceSpec extends AnyFunSpec with Matchers {
  val chance = new Chance {
    override def Luck: Int = 40
  }

  it("should have Luck value") {
    chance.Luck shouldBe 40
  }
}