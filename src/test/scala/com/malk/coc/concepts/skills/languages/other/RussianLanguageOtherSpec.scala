package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.BehavesLikeLanguageSkill
import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.skills.languages._
import com.malk.coc.concepts.skills.BehavesLikeSkill

class RussianLanguageOtherSpec extends BehavesLikeLanguageSkill with BehavesLikeSkill {
  val skillName = "Language Other (Russian)"

  val skill = RussianLanguageOther()

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
      RussianLanguageOther(),
      EnglishLanguageOther(),
      LanguageOwn(Education(50))(Russian),
      LanguageOwn(Education(60))(Polish)
    )
  )
}
