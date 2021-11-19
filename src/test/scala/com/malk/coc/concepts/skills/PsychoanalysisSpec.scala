package com.malk.coc.concepts.skills

class PsychoanalysisSpec extends BehavesLikeSkill {
  val skillName = "Psychoanalysis"

  val skill = Psychoanalysis()

  behavesLikeSkill(skill, skillName, 1, true, 11)
}