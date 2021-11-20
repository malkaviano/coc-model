package com.malk.coc.concepts.skills

import com.malk.coc.traits.UncommonSkill

class DivingSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Diving"

  val skill = Diving()

  behavesLikeSkill(skill, skillName, 1, true, 11)

  behavesLikeSkillComparing(skill, skillName, 1, true)

  it(s"should have tag of Uncommon skill") {
    skill.isInstanceOf[UncommonSkill] shouldBe true
  }
}
