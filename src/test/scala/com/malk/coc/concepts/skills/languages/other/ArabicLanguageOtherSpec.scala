package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.BehavesLikeLanguageSkill
import com.malk.coc.concepts.skills.languages._
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.skills.languages.own.LanguageOwn

class ArabicLanguageOtherSpec extends BehavesLikeLanguageSkill {
  val skillName = "Language Other (Arabic)"

  val skill = ArabicLanguageOther()

  checkLanguageBehavior(
    skill,
    skillName,
    1,
    true,
    20,
    (
      ArabicLanguageOther(),
      EnglishLanguageOther(),
      LanguageOwn(Education(50))(Arabic),
      LanguageOwn(Education(60))(Spanish)
    )
  )
}
