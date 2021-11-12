package com.malk.coc.concepts.skills

class HistorySpec extends BehavesLikeSkill {
  val skillName = "History"

  val skill = History(spent = 10)

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
