package com.malk.coc.concepts.skills

class SeaSpec extends BehavesLikeSkill {
  val skillName = "Survival (Sea)"

  val skill = Sea(spent = 10)

  behavesLikeSkill(skill, skillName, 10, true, 20)
}