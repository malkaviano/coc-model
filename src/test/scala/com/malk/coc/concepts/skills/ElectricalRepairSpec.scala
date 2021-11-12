package com.malk.coc.concepts.skills

class ElectricalRepairSpec extends BehavesLikeSkill {
  val skillName = "Electrical Repair"

  val skill = ElectricalRepair(spent = 10)

  behavesLikeSkill(skill, skillName, 10, true, 20)
}
