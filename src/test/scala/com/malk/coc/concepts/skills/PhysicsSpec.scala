package com.malk.coc.concepts.skills

class PhysicsSpec extends BehavesLikeSkill {
  val skillName = "Science (Physics)"

  val skill = Physics()

  behavesLikeSkill(skill, skillName, 1, true, 11)
}