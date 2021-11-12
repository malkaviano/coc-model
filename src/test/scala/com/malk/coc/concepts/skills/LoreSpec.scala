package com.malk.coc.concepts.skills

import com.malk.coc.traits.UncommonSkill

class LoreSpec extends BehavesLikeGenericSkill {
  val skillName = "Lore"

  val skill = new Lore(10) { }

  behavesLikeGenericSkill(skill, skillName, 1, false)

  it(s"should have tag of Uncommon skill") {
    skill.isInstanceOf[UncommonSkill] shouldBe true
  }
}
