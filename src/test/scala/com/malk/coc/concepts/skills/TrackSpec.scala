package com.malk.coc.concepts.skills

class TrackSpec extends BehavesLikeSkill {
  val skillName = "Track"

  val skill = Track()

  behavesLikeSkill(skill, skillName, 10, true, 20)
}
