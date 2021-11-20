package com.malk.coc.concepts.skills

class LibraryUseSpec extends BehavesLikeSkill with BehavesLikeSkillComparing {
  val skillName = "Library Use"

  val skill = LibraryUse()

  behavesLikeSkill(skill, skillName, 20, true, 30)

  behavesLikeSkillComparing(skill, skillName, 20, true)
}