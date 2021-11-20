package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.BehavesLikeLanguageSkill
import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.skills.languages._

class FrenchLanguageOtherSpec extends BehavesLikeLanguageSkill {
  val skillName = "Language Other (French)"

  val skill = FrenchLanguageOther()

  behavesLikeLanguageSkill(
    skill,
    skillName,
    1,
    true,
    20,
    FrenchLanguageOther(),
    EnglishLanguageOther(),
    LanguageOwn(Education(50))(French),
    LanguageOwn(Education(60))(Spanish)
  )
}
