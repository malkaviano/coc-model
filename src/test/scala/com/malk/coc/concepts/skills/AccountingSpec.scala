package com.malk.coc.concepts.skills

class AccountingSpec extends BehavesLikeSkill {
  val skillName = "Accounting"

  val skill = Accounting(spent = 10)

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
