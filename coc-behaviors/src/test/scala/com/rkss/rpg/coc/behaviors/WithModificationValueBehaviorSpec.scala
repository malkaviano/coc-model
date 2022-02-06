package com.rkss.rpg.coc.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import com.rkss.rpg.coc.behaviors.testing.fakes._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.concepts.commons._

final class WithModificationValueBehaviorSpec
    extends AnyFunSpec
    with Matchers {
  describe("With modification value behavior") {
    val fake = FakeGenericCharacteristic(Appearance, 10)

    it("should have initial value 0") {
      fake.modificationValue shouldBe 0
    }

    Seq(
      (
        ValueModification(Appearance, -5),
        ValueModified(Appearance, -5, -5, 0)
      ),
      (
        ValueModification(Appearance, 10),
        ValueModified(Appearance, 10, 5, -5)
      ),
    ).foreach {
      case (modification, expected) => {
        describe(s"Modifying an entity with $modification") {
          it(s"should have modification value $expected") {
            val result = fake.modify(modification)

            result shouldBe expected
          }
        }
      }
    }
  }
}
