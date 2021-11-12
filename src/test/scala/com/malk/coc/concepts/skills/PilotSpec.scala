package com.malk.coc.concepts.skills

class PilotSpec extends BehavesLikeGenericSkill {
  val skillName = "Pilot"

  val skill = new Pilot(10) {}

  behavesLikeGenericSkill(skill, skillName, 1, true)
}
