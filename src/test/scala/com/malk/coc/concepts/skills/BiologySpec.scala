package com.malk.coc.concepts.skills

class BiologySpec extends BehavesLikeSkill {
  val skillName = "Science (Biology)"

  val skill = Biology(spent = 10)

  behavesLikeSkill(skill, skillName, 1, true, 11)
}