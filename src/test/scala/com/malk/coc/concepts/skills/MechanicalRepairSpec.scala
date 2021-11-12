package com.malk.coc.concepts.skills

class MechanicalRepairSpec extends BehavesLikeSkill {
  val skillName = "Mechanical Repair"

  val skill = MechanicalRepair(spent = 10)

  behavesLikeSkill(skill, skillName, 10, true, 20)
}
