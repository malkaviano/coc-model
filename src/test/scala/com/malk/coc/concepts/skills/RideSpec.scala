package com.malk.coc.concepts.skills

class RideSpec extends BehavesLikeSkill {
  val skillName = "Ride"

  val skill = Ride(spent = 10)

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
