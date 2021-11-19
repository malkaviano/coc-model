package com.malk.coc.concepts.skills

class LocksmithSpec extends BehavesLikeSkill {
  val skillName = "Locksmith"

  val skill = Locksmith()

  behavesLikeSkill(skill, skillName, 1, true, 11)
}
