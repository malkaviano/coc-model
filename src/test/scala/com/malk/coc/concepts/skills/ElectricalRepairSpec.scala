package com.malk.coc.concepts.skills

class ElectricalRepairSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Electrical Repair"

  val skill = ElectricalRepair()

  behavesLikeSkill(skill, skillName, 10, true, 20)

  behavesLikeSkillComparing(skill, skillName, 10, true)
}
