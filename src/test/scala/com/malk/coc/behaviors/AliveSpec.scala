package com.malk.coc.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class AliveSpec extends AnyFunSpec with Matchers {
  val alive = new Alive {
    def HP: Int = 10
  }

  it("should have HP (Hit Points) value") {
    alive.HP shouldBe 10
  }
}