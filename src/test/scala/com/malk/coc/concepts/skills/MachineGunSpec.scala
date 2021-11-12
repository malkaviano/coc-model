package com.malk.coc.concepts.skills

class MachineGunSpec extends BehavesLikeSkill {
  val skillName = "Firearm (Machine Gun)"

  val skill = MachineGun(spent = 10)

  behavesLikeSkill(skill, skillName, 10, false, 20)
}