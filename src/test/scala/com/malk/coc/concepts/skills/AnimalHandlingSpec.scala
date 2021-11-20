package com.malk.coc.concepts.skills

import com.malk.coc.traits.UncommonSkill

class AnimalHandlingSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Animal Handling"

  val skill = AnimalHandling()

  behavesLikeSkill(skill, skillName, 5, true, 15)

  behavesLikeSkillComparing(skill, skillName, 5, true)

  it(s"should have tag of Uncommon skill") {
    skill.isInstanceOf[UncommonSkill] shouldBe true
  }
}
