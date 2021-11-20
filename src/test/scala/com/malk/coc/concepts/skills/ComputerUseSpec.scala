package com.malk.coc.concepts.skills

import com.malk.coc.traits.ModernEraSkill

class ComputerUseSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Computer Use"

  val skill = ComputerUse()

  behavesLikeSkill(skill, skillName, 5, true, 15)

  behavesLikeSkillComparing(skill, skillName, 5, true)

  it(s"should have tag of ModernEra Skill") {
    skill.isInstanceOf[ModernEraSkill] shouldBe true
  }
}
