package com.malk.coc.traits

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class KnowledgeSpec extends AnyFunSpec with Matchers {
  val edu = new Knowledge {
    override def EDU: Int = 76
  }

  it("should have EDU value") {
    edu.EDU shouldBe 76
  }
}