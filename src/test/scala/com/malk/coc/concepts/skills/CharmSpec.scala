package com.malk.coc.concepts.skills

class CharmSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Charm"

  val skill = Charm()

  behavesLikeSkill(skill, skillName, 15, true, 25)

  behavesLikeSkillComparing(skill, skillName, 15, true)
}