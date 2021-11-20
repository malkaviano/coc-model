package com.malk.coc.concepts.skills

class AccountingSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Accounting"

  val skill = Accounting()

  behavesLikeSkill(skill, skillName, 5, true, 15)

  behavesLikeSkillComparing(skill, skillName, 5, true)
}
