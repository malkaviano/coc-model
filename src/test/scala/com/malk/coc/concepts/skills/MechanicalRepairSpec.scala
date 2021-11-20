package com.malk.coc.concepts.skills

class MechanicalRepairSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Mechanical Repair"

  val skill = MechanicalRepair()

  behavesLikeSkill(skill, skillName, 10, true, 20)

  behavesLikeSkillComparing(skill, skillName, 10, true)
}
