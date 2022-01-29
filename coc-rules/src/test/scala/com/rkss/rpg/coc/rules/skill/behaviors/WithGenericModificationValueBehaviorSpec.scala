package com.rkss.rpg.coc.rules.skill.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.rkss.rpg.coc.rules.testing.fakes._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.concepts._

final class WithGenericModificationValueBehaviorSpec
    extends AnyFunSpec
    with Matchers {
  describe("With modification value behavior") {
    val fake = FakeGenericCharacteristic(Appearance, 10)

    it("should have initial value 0") {
      fake.modificationValue shouldBe 0
    }

    Seq(
      (ValueModificationIncrease(Appearance, 10), 10),
      (ValueModificationDecrease(Appearance, 5), -5)
    ).foreach {
      case (modification, expected) => {
        describe(s"Modifying an entity with $modification") {
          it(s"should have modification value $expected") {
            val fake = FakeGenericCharacteristic(Appearance, 10)

            fake.modify(modification)

            fake.modificationValue shouldBe expected
          }
        }
      }
    }
  }
}
