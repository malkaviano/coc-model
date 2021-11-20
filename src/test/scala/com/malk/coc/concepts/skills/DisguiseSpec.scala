package com.malk.coc.concepts.skills

class DisguiseSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Disguise"

  val skill = Disguise()

  behavesLikeSkill(skill, skillName, 5, true, 15)

  behavesLikeSkillComparing(skill, skillName, 5, true)
}
