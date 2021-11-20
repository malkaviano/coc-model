package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.BehavesLikeLanguageSkill
import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.skills.languages._

class ItalianLanguageOtherSpec extends BehavesLikeLanguageSkill {
  val skillName = "Language Other (Italian)"

  val skill = ItalianLanguageOther()

  checkLanguageBehavior(
    skill,
    skillName,
    1,
    true,
    20,
    (
      ItalianLanguageOther(),
      EnglishLanguageOther(),
      LanguageOwn(Education(50))(Italian),
      LanguageOwn(Education(60))(Spanish)
    )
  )
}
