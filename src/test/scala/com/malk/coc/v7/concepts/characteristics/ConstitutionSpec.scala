package com.malk.coc.v7.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class ConstitutionSpec extends AnyFunSpec with Matchers {
  describe("The Constitution") {
    val con = Constitution(55)

    it("should have name Constitution") {
      con.name shouldBe "CON"
    }

    it("should have value 55") {
      con.value shouldBe 55
    }
  }
}