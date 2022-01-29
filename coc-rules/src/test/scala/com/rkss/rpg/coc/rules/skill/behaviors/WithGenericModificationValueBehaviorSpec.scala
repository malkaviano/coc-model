package com.rkss.rpg.coc.rules.skill.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.rkss.rpg.coc.rules.testing.fakes._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.concepts.ValueModification

final class WithGenericModificationValueBehaviorSpec
    extends AnyFunSpec
    with Matchers {
  describe("With modification value behavior") {
    val fake = FakeGenericCharacteristic(Appearance, 10)

    it("should have initial value 0") {
      fake.modificationValue shouldBe 0
    }

    describe("Modifying an entity with 10") {
      it("should have modification value 10") {
        val modification = ValueModification(Appearance, 10)

        fake.modify(modification)

        fake.modificationValue shouldBe 10
      }
    }
  }
}
