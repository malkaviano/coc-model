package com.malk.coc.concepts.skills

class ZoologySpec extends BehavesLikeSkill {
  val skillName = "Science (Zoology)"

  val skill = Zoology(spent = 10)

  behavesLikeSkill(skill, skillName, 1, true, 11)
}