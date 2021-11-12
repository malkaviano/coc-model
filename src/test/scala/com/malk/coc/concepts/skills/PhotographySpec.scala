package com.malk.coc.concepts.skills

class PhotographySpec extends BehavesLikeSkill {
  val skillName = "Art and Craft (Photography)"

  val skill = Photography(spent = 10)

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
