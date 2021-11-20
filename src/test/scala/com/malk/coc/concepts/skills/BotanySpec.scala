package com.malk.coc.concepts.skills

class BotanySpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Science (Botany)"

  val skill = Botany()

  behavesLikeSkill(skill, skillName, 1, true, 11)

  behavesLikeSkillComparing(skill, skillName, 1, true)
}