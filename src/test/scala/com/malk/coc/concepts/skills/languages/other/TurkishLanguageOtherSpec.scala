package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.BehavesLikeLanguageSkill
import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.skills.languages._

class TurkishLanguageOtherSpec extends BehavesLikeLanguageSkill {
  val skillName = "Language Other (Turkish)"

  val skill = TurkishLanguageOther()

  behavesLikeLanguageSkill(
    skill,
    skillName,
    1,
    true,
    20,
    TurkishLanguageOther(),
    EnglishLanguageOther(),
    LanguageOwn(Education(50))(Turkish),
    LanguageOwn(Education(60))(Spanish)
  )
}
