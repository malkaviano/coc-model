package com.malk.coc.concepts.skills

import com.malk.coc.traits.UncommonSkill

class AnimalHandlingSpec extends BehavesLikeSkill {
  val skillName = "Animal Handling"

  val skill = AnimalHandling(spent = 10)

  behavesLikeSkill(skill, skillName, 5, true, 15)

  it(s"should have tag of Uncommon skill") {
    skill.isInstanceOf[UncommonSkill] shouldBe true
  }
}
