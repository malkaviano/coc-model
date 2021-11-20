package com.malk.coc.concepts.skills

class RifleAndShotgunSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Firearm (Rifle/Shotgun)"

  val skill = RifleAndShotgun()

  behavesLikeSkill(skill, skillName, 25, false, 35)

  behavesLikeSkillComparing(skill, skillName, 25, false)
}
