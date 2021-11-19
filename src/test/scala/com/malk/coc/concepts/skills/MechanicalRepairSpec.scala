package com.malk.coc.concepts.skills

class MechanicalRepairSpec extends BehavesLikeSkill {
  val skillName = "Mechanical Repair"

  val skill = MechanicalRepair()

  behavesLikeSkill(skill, skillName, 10, true, 20)
}
