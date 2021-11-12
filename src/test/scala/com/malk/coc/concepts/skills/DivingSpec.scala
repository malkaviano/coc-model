package com.malk.coc.concepts.skills

import com.malk.coc.traits.UncommonSkill

class DivingSpec extends BehavesLikeSkill {
  val skillName = "Diving"

  val skill = Diving(spent = 10)

  behavesLikeSkill(skill, skillName, 1, true, 11)

  it(s"should have tag of Uncommon skill") {
    skill.isInstanceOf[UncommonSkill] shouldBe true
  }
}
