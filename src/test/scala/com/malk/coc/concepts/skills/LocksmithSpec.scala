package com.malk.coc.concepts.skills

class LocksmithSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Locksmith"

  val skill = Locksmith()

  behavesLikeSkill(skill, skillName, 1, true, 11)

  behavesLikeSkillComparing(skill, skillName, 1, true)
}
