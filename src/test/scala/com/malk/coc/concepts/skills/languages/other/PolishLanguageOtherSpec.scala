package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.BehavesLikeLanguageSkill
import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.skills.languages._

class PolishLanguageOtherSpec extends BehavesLikeLanguageSkill {
  val skillName = "Language Other (Polish)"

  val skill = PolishLanguageOther()

  checkLanguageBehavior(
    skill,
    skillName,
    1,
    true,
    20,
    (
      PolishLanguageOther(),
      EnglishLanguageOther(),
      LanguageOwn(Education(50))(Polish),
      LanguageOwn(Education(60))(Chinese)
    )
  )
}
