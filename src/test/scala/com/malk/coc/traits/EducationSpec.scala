package com.malk.coc.traits

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class EducationSpec extends AnyFunSpec with Matchers {
  val edu = new Education {
    override def EDU: Int = 76
  }

  it("should have EDU value") {
    edu.EDU shouldBe 76
  }
}