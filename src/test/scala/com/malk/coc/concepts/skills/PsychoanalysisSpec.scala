package com.malk.coc.concepts.skills

class PsychoanalysisSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Psychoanalysis"

  val skill = Psychoanalysis()

  behavesLikeSkill(skill, skillName, 1, true, 11)

  behavesLikeSkillComparing(skill, skillName, 1, true)
}