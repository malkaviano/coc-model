package com.malk.coc.concepts.skills

import com.malk.coc.traits.UncommonSkill

class ReadLipsSpec extends BehavesLikeSkill {
  val skillName = "Read Lips"
  val skill = ReadLips(spent = 10)

  behavesLikeSkill(skill, skillName, 1, true, 11)

  it(s"should have tag of Uncommon skill") {
    skill.isInstanceOf[UncommonSkill] shouldBe true
  }
}
