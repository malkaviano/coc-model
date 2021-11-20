package com.malk.coc.concepts.skills

class MathematicsSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Science (Mathematics)"

  val skill = Mathematics()

  behavesLikeSkill(skill, skillName, 10, true, 20)

  behavesLikeSkillComparing(skill, skillName, 10, true)
}