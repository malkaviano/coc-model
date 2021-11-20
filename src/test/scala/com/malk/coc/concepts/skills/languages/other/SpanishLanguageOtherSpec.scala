package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.BehavesLikeLanguageSkill
import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.skills.languages._
import com.malk.coc.concepts.skills.BehavesLikeSkill

class SpanishLanguageOtherSpec extends BehavesLikeLanguageSkill with BehavesLikeSkill {
  val skillName = "Language Other (Spanish)"

  val skill = SpanishLanguageOther()

  behavesLikeSkill(
    skill,
    skillName,
    1,
    true,
    20
  )

  checkLanguageBehavior(
    skill,
    (
      SpanishLanguageOther(),
      EnglishLanguageOther(),
      LanguageOwn(Education(50))(Spanish),
      LanguageOwn(Education(60))(Polish)
    )
  )
}
