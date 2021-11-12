package com.malk.coc.concepts.skills

class PhysicsSpec extends BehavesLikeSkill {
  val skillName = "Science (Physics)"

  val skill = Physics(spent = 10)

  behavesLikeSkill(skill, skillName, 1, true, 11)
}