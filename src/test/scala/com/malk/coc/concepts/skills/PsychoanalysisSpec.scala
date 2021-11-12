package com.malk.coc.concepts.skills

class PsychoanalysisSpec extends BehavesLikeSkill {
  val skillName = "Psychoanalysis"

  val skill = Psychoanalysis(spent = 10)

  behavesLikeSkill(skill, skillName, 1, true, 11)
}