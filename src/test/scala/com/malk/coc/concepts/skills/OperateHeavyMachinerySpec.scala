package com.malk.coc.concepts.skills

class OperateHeavyMachinerySpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Operate Heavy Machinery"

  val skill = OperateHeavyMachinery()

  behavesLikeSkill(skill, skillName, 1, true, 11)

  behavesLikeSkillComparing(skill, skillName, 1, true)
}
