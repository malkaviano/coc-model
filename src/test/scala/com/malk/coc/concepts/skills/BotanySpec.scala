package com.malk.coc.concepts.skills

class BotanySpec extends BehavesLikeSkill {
  val skillName = "Science (Botany)"

  val skill = Botany()

  behavesLikeSkill(skill, skillName, 1, true, 11)
}