package com.malk.coc.concepts.skills

class MachineGunSpec extends BehavesLikeSkill {
  val skillName = "Firearm (Machine Gun)"

  val skill = MachineGun()

  behavesLikeSkill(skill, skillName, 10, false, 20)
}