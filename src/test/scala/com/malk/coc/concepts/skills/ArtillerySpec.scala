package com.malk.coc.concepts.skills

import com.malk.coc.traits.UncommonSkill

class ArtillerySpec extends BehavesLikeSkill {
  val skillName = "Artillery"

  val skill = Artillery()

  behavesLikeSkill(skill, skillName, 1, false, 11)

  it(s"should have tag of Uncommon skill") {
    skill.isInstanceOf[UncommonSkill] shouldBe true
  }
}
