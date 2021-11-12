package com.malk.coc.concepts.skills

class ActingSpec extends BehavesLikeSkill {
  val skillName = "Art and Craft (Acting)"

  val skill = Acting(spent = 10)

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
