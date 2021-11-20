package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.BehavesLikeLanguageSkill
import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.skills.languages._
import com.malk.coc.concepts.skills.BehavesLikeSkill

class PolishLanguageOtherSpec extends BehavesLikeLanguageSkill with BehavesLikeSkill {
  val skillName = "Language Other (Polish)"

  val skill = PolishLanguageOther()

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
      PolishLanguageOther(),
      EnglishLanguageOther(),
      LanguageOwn(Education(50))(Polish),
      LanguageOwn(Education(60))(Chinese)
    )
  )
}
