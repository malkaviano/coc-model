package com.malk.coc.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class DamageableSpec extends AnyFunSpec with Matchers {
  val damageable = new Damageable {
    def HP: Int = 10
  }

  it("should have HP (Hit Points) value") {
    damageable.HP shouldBe 10
  }
}