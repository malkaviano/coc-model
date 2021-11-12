package com.malk.coc.concepts.skills

class HeavyWeaponsSpec extends BehavesLikeSkill {
  val skillName = "Firearm (Heavy Weapons)"

  val skill = HeavyWeapons(spent = 10)

  behavesLikeSkill(skill, skillName, 10, false, 20)
}