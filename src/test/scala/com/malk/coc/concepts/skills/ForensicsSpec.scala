package com.malk.coc.concepts.skills

class ForensicsSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Science (Forensics)"

  val skill = Forensics()

  behavesLikeSkill(skill, skillName, 1, true, 11)

  behavesLikeSkillComparing(skill, skillName, 1, true)
}
