package com.malk.coc.concepts.skills

class ChemistrySpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Science (Chemistry)"

  val skill = Chemistry()

  behavesLikeSkill(skill, skillName, 1, true, 11)

  behavesLikeSkillComparing(skill, skillName, 1, true)
}