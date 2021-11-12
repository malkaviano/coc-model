package com.malk.coc.concepts.skills

class DriveAutoSpec extends BehavesLikeSkill {
  val skillName = "Drive Auto"

  val skill = DriveAuto(spent = 10)

  behavesLikeSkill(skill, skillName, 20, true, 30)
}