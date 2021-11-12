package com.malk.coc.concepts.skills

import com.malk.coc.traits.ModernEraSkill

class ComputerUseSpec extends BehavesLikeSkill {
  val skillName = "Computer Use"

  val skill = ComputerUse(spent = 10)

  behavesLikeSkill(skill, skillName, 5, true, 15)

  it(s"should have tag of ModernEra Skill") {
    skill.isInstanceOf[ModernEraSkill] shouldBe true
  }
}
