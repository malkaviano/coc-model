package com.malk.coc.concepts.skills

class TrackSpec extends BehavesLikeSkill {
  val skillName = "Track"

  val skill = Track(spent = 10)

  behavesLikeSkill(skill, skillName, 10, true, 20)
}