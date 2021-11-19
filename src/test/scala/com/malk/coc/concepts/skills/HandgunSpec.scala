package com.malk.coc.concepts.skills

class HandgunSpec extends BehavesLikeSkill {
  val skillName = "Firearm (Handgun)"

  val skill = Handgun()

  behavesLikeSkill(skill, skillName, 20, false, 30)
}