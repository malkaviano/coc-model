package com.malk.coc.concepts.skills

class AccountingSpec extends BehavesLikeSkill {
  val skillName = "Accounting"

  val skill = Accounting()

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
