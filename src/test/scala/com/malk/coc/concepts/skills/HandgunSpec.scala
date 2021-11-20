package com.malk.coc.concepts.skills

class HandgunSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Firearm (Handgun)"

  val skill = Handgun()

  behavesLikeSkill(skill, skillName, 20, false, 30)

  behavesLikeSkillComparing(skill, skillName, 20, false)
}