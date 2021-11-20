package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.BehavesLikeLanguageSkill
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.skills.languages._

class EnglishLanguageOtherSpec extends BehavesLikeLanguageSkill {
  val skillName = "Language Other (English)"

  val skill = EnglishLanguageOther()

  checkLanguageBehavior(
    skill,
    skillName,
    1,
    true,
    20,
    (
      EnglishLanguageOther(),
      ArabicLanguageOther(),
      LanguageOwn(Education(50))(English),
      LanguageOwn(Education(60))(German)
    )
  )
}
