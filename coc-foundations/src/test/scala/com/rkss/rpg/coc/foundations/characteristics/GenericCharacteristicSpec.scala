package com.rkss.rpg.coc.foundations.characteristics

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.rkss.rpg.coc.concepts.roll.HardDifficulty
import com.rkss.rpg.coc.concepts.roll.ExtremeDifficulty

class GenericCharacteristicSpec extends AnyFunSpec with Matchers {
  describe("Any Characteristic behavior") {
    val characteristic = new GenericCharacteristic("anyChar", 40)

    it("should have a name") {
      characteristic.name shouldBe "anyChar"
    }

    it("should have regular value") {
      characteristic.value() shouldBe 40
    }

    it("should have hard value") {
      characteristic.value(HardDifficulty) shouldBe 20
    }

    it("should have extreme value") {
      characteristic.value(ExtremeDifficulty) shouldBe 8
    }
  }
}
