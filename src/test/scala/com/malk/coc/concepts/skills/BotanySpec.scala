package com.malk.coc.concepts.skills

class BotanySpec extends BehavesLikeSkill {
  val skillName = "Science (Botany)"

  val skill = Botany(spent = 10)

  behavesLikeSkill(skill, skillName, 1, true, 11)
}