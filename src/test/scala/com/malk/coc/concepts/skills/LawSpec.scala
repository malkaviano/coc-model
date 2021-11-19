package com.malk.coc.concepts.skills

class LawSpec extends BehavesLikeSkill {
  val skillName = "Law"

  val skill = Law()

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
