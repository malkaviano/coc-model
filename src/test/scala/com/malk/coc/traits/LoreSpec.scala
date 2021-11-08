package com.malk.coc.traits

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class LoreSpec extends AnyFunSpec with Matchers {
  val lore = new Lore {
    override def EDU: Int = 76
  }

  it("should have EDU value") {
    lore.EDU shouldBe 76
  }
}