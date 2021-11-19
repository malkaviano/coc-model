package com.malk.coc.concepts.skills

import org.scalatest.funspec.AnyFunSpec

import com.malk.coc.concepts.characteristics.Dexterity

class DodgeSpec extends AnyFunSpec with BehavesLikeSkill {
  describe("The Dodge skill") {
    val dex = Dexterity(67)

    val skill = Dodge(dex)()

    behavesLikeSkill(skill, "Dodge", 33, false, 11)
  }
}
