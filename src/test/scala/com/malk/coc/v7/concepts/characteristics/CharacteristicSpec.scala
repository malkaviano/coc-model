package com.malk.coc.v7.concepts.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class CharacteristicSpec extends AnyFunSpec with Matchers {
  describe("The characteristic concept") {
    val characteristic = new Characteristic("generic", 45) {}

    it("should have a name") {
      characteristic.name should be equals "generic"
    }

    it("should have a value") {
      characteristic.value should be equals 45
    }
  }
}