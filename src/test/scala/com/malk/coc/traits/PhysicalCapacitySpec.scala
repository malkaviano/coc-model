package com.malk.coc.traits

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class PhysicalCapacitySpec extends AnyFunSpec with Matchers {
  val pc = new PhysicalCapacity {
    def STR: Int = 40
    def CON: Int = 50
    def SIZ: Int = 60
    def DEX: Int = 70
  }

  it("should have STR (Strength) value") {
    pc.STR shouldBe 40
  }

  it("should have CON (Constitution) value") {
    pc.CON shouldBe 50
  }

  it("should have SIZ (Size) value") {
    pc.SIZ shouldBe 60
  }

  it("should have DEX (Dexterity) value") {
    pc.DEX shouldBe 70
  }
}