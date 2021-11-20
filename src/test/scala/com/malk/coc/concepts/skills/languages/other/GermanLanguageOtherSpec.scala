package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.BehavesLikeLanguageSkill
import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.skills.languages._

class GermanLanguageOtherSpec extends BehavesLikeLanguageSkill {
  val skillName = "Language Other (German)"

  val skill = GermanLanguageOther()

  behavesLikeLanguageSkill(
    skill,
    skillName,
    1,
    true,
    20,
    GermanLanguageOther(),
    EnglishLanguageOther(),
    LanguageOwn(Education(50))(German),
    LanguageOwn(Education(60))(Spanish)
  )
}
