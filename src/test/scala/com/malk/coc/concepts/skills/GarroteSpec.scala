package com.malk.coc.concepts.skills

class GarroteSpec extends BehavesLikeSkill {
  val skillName = "Fighting (Garrote)"

  val skill = Garrote(spent = 10)

  behavesLikeSkill(skill, skillName, 15, false, 25)
}