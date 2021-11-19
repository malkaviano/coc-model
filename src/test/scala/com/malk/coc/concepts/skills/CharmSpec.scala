package com.malk.coc.concepts.skills

class CharmSpec extends BehavesLikeSkill {
  val skillName = "Charm"

  val skill = Charm()

  behavesLikeSkill(skill, skillName, 15, true, 25)
}