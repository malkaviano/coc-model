package com.malk.coc.behaviors

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class MeleeDamageEnhancementSpec extends AnyFunSpec with Matchers {
  val mde = new MeleeDamageEnhancement {
    def DB: Int = 20
  }

  it("should have DB (Damage Bonus) value") {
    mde.DB shouldBe 20
  }
}