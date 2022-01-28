package com.rkss.rpg.coc.rules.skill.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.rkss.rpg.coc.rules.testing.fakes.FakeCharacteristic
import com.rkss.rpg.coc.concepts.characteristic._

final class WithModificationValueBehaviorSpec extends AnyFunSpec with Matchers {
  describe("With modification value behavior") {
    val fake = FakeCharacteristic(Appearance, 10)

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
