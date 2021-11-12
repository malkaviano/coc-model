package com.malk.coc.concepts.skills

class LanguageOtherSpec extends BehavesLikeGenericSkill {
  val skillName = "Language Other"

  val skill = new LanguageOther(10) {}

  behavesLikeGenericSkill(skill, skillName, 1, true)
}
