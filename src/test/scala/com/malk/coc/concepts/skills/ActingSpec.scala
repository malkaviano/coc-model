package com.malk.coc.concepts.skills

class ActingSpec extends BehavesLikeSkill {
  val skillName = "Art and Craft (Acting)"

  val skill = Acting()

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
