package com.malk.coc.concepts.skills

class RifleAndShotgunSpec extends BehavesLikeSkill {
  val skillName = "Firearm (Rifle/Shotgun)"

  val skill = RifleAndShotgun(spent = 10)

  behavesLikeSkill(skill, skillName, 25, false, 35)
}