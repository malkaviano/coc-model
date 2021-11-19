package com.malk.coc.concepts.skills

class MathematicsSpec extends BehavesLikeSkill {
  val skillName = "Science (Mathematics)"

  val skill = Mathematics()

  behavesLikeSkill(skill, skillName, 10, true, 20)
}