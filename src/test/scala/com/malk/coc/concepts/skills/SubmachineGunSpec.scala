package com.malk.coc.concepts.skills

class SubmachineGunSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Firearm (Submachine Gun)"

  val skill = SubmachineGun()

  behavesLikeSkill(skill, skillName, 15, false, 25)

  behavesLikeSkillComparing(skill, skillName, 15, false)
}