package com.malk.coc.concepts.skills

class LibraryUseSpec extends BehavesLikeSkill {
  val skillName = "Library Use"

  val skill = LibraryUse(spent = 10)

  behavesLikeSkill(skill, skillName, 20, true, 30)
}