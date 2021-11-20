package com.malk.coc.concepts.skills.language.other

import com.malk.coc.concepts.skills.BehavesLikeSkill

class ArabicLanguageSpec extends BehavesLikeSkill {
  val skillName = "Language Other (Arabic)"

  val skill = ArabicLanguageOther()

  behavesLikeSkill(skill, skillName, 1, true, 20)
}