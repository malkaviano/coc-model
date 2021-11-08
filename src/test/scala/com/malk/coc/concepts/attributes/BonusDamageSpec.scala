package com.malk.coc.concepts.attributes

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class BonusDamageSpec extends AnyFunSpec with Matchers {
  import com.malk.coc.concepts.characteristics.{Strength, Size}

  describe("The Bonus Damage") {
    val bd = BonusDamage(str = Strength(40), siz = Size(60))

    it("should have name Bonus Damage") {
      bd.name shouldBe "Bonus Damage"
    }

    it("should have value 100") {
      bd.value shouldBe 100
    }
  }
}