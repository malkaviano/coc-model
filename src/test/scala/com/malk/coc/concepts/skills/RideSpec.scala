package com.malk.coc.concepts.skills

class RideSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Ride"

  val skill = Ride()

  behavesLikeSkill(skill, skillName, 5, true, 15)

  behavesLikeSkillComparing(skill, skillName, 5, true)
}
