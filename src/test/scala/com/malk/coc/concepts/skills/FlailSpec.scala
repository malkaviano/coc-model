package com.malk.coc.concepts.skills

class FlailSpec extends BehavesLikeSkill {
  val skillName = "Fighting (Flail)"

  val skill = Flail(spent = 10)

  behavesLikeSkill(skill, skillName, 10, false, 20)
}