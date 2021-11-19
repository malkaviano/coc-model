package com.malk.coc.concepts.skills

class FlailSpec extends BehavesLikeSkill {
  val skillName = "Fighting (Flail)"

  val skill = Flail()

  behavesLikeSkill(skill, skillName, 10, false, 20)
}