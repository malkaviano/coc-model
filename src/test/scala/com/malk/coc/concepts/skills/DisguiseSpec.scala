package com.malk.coc.concepts.skills

class DisguiseSpec extends BehavesLikeSkill {
  val skillName = "Disguise"

  val skill = Disguise()

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
