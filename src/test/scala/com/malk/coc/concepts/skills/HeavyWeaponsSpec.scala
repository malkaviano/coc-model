package com.malk.coc.concepts.skills

class HeavyWeaponsSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Firearm (Heavy Weapons)"

  val skill = HeavyWeapons()

  behavesLikeSkill(skill, skillName, 10, false, 20)

  behavesLikeSkillComparing(skill, skillName, 10, false)
}