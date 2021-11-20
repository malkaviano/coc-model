package com.malk.coc.concepts.skills

class GarroteSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Fighting (Garrote)"

  val skill = Garrote()

  behavesLikeSkill(skill, skillName, 15, false, 25)

  behavesLikeSkillComparing(skill, skillName, 15, false)
}