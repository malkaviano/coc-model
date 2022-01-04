package com.rkss.rpg.coc.rules.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.rkss.rpg.coc.rules.testing.fakes.FakeCharacteristic

final class WithModificationValueBehaviorSpec extends AnyFunSpec with Matchers {
  describe("With modification value behavior") {
    val fake = FakeCharacteristic(10)

    it("should have initial value 0") {
      fake.modificationValue shouldBe 0
    }

    describe("Modifying an entity with 10") {
      it("should have modification value 10") {
        fake.modify(10)

        fake.modificationValue shouldBe 10
      }
    }
  }
}
