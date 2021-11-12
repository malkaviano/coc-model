package com.malk.coc.concepts.skills

import com.malk.coc.traits.ModernEraSkill

class ElectronicsSpec extends BehavesLikeSkill {
  val skillName = "Electronics"

  val skill = Electronics(spent = 10)

  behavesLikeSkill(skill, skillName, 1, true, 11)

  it(s"should have tag of ModernEra Skill") {
    skill.isInstanceOf[ModernEraSkill] shouldBe true
  }
}
