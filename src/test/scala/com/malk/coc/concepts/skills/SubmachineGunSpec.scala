package com.malk.coc.concepts.skills

class SubmachineGunSpec extends BehavesLikeSkill {
  val skillName = "Firearm (Submachine Gun)"

  val skill = SubmachineGun()

  behavesLikeSkill(skill, skillName, 15, false, 25)
}