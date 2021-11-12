package com.malk.coc.concepts.skills

class ChemistrySpec extends BehavesLikeSkill {
  val skillName = "Science (Chemistry)"

  val skill = Chemistry(spent = 10)

  behavesLikeSkill(skill, skillName, 1, true, 11)
}