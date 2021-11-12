package com.malk.coc.concepts.skills

class OperateHeavyMachinerySpec extends BehavesLikeSkill {
  val skillName = "Operate Heavy Machinery"

  val skill = OperateHeavyMachinery(spent = 10)

  behavesLikeSkill(skill, skillName, 1, true, 11)
}
