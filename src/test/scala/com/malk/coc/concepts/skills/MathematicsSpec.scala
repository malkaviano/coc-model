package com.malk.coc.concepts.skills

class MathematicsSpec extends BehavesLikeSkill {
  val skillName = "Science (Mathematics)"

  val skill = Mathematics(spent = 10)

  behavesLikeSkill(skill, skillName, 10, true, 20)
}