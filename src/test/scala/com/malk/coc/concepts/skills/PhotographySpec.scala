package com.malk.coc.concepts.skills

class PhotographySpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Art and Craft (Photography)"

  val skill = Photography()

  behavesLikeSkill(skill, skillName, 5, true, 15)

  behavesLikeSkillComparing(skill, skillName, 5, true)
}
