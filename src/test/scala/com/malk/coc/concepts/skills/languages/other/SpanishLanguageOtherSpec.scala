package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.BehavesLikeLanguageSkill
import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.skills.languages._

class SpanishLanguageOtherSpec extends BehavesLikeLanguageSkill {
  val skillName = "Language Other (Spanish)"

  val skill = SpanishLanguageOther()

  behavesLikeLanguageSkill(
    skill,
    skillName,
    1,
    true,
    20,
    SpanishLanguageOther(),
    EnglishLanguageOther(),
    LanguageOwn(Education(50))(Spanish),
    LanguageOwn(Education(60))(Polish)
  )
}
