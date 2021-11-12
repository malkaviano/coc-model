package com.malk.coc.concepts.skills

class LawSpec extends BehavesLikeSkill {
  val skillName = "Law"

  val skill = Law(spent = 10)

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
