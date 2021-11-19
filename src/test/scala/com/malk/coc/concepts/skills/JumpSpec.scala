package com.malk.coc.concepts.skills

class JumpSpec extends BehavesLikeSkill {
  val skillName = "Jump"

  val skill = Jump()

  behavesLikeSkill(skill, skillName, 20, true, 30)
}