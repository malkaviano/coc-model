package com.malk.coc.concepts.skills

class TrackSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Track"

  val skill = Track()

  behavesLikeSkill(skill, skillName, 10, true, 20)

  behavesLikeSkillComparing(skill, skillName, 10, true)
}
