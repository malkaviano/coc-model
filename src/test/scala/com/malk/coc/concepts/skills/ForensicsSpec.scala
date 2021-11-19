package com.malk.coc.concepts.skills

class ForensicsSpec extends BehavesLikeSkill {
  val skillName = "Science (Forensics)"

  val skill = Forensics()

  behavesLikeSkill(skill, skillName, 1, true, 11)
}
