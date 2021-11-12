package com.malk.coc.concepts.skills

class NaturalWorldSpec extends BehavesLikeSkill {
  val skillName = "Natural World"

  val skill = NaturalWorld(spent = 10)

  behavesLikeSkill(skill, skillName, 10, true, 20)
}
