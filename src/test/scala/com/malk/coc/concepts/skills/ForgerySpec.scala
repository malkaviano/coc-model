package com.malk.coc.concepts.skills

class ForgerySpec extends BehavesLikeSkill {
  val skillName = "Art and Craft (Forgery)"

  val skill = Forgery(spent = 10)

  behavesLikeSkill(skill, skillName, 5, true, 15)
}