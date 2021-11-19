package com.malk.coc.concepts.skills

class OccultSpec extends BehavesLikeSkill {
  val skillName = "Occult"

  val skill = Occult()

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
