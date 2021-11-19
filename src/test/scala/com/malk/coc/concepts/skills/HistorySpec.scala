package com.malk.coc.concepts.skills

class HistorySpec extends BehavesLikeSkill {
  val skillName = "History"

  val skill = History()

  behavesLikeSkill(skill, skillName, 5, true, 15)
}
