package com.malk.coc.concepts.skills

class ListenSpec extends BehavesLikeSkill {
  val skillName = "Listen"

  val skill = Listen(spent = 10)

  behavesLikeSkill(skill, skillName, 20, true, 30)
}