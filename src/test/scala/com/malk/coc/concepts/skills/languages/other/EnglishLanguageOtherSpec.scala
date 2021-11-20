package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.BehavesLikeLanguageSkill
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.skills.languages._
import com.malk.coc.concepts.skills.BehavesLikeSkill

class EnglishLanguageOtherSpec extends BehavesLikeLanguageSkill with BehavesLikeSkill {
  val skillName = "Language Other (English)"

  val skill = EnglishLanguageOther()

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
      EnglishLanguageOther(),
      ArabicLanguageOther(),
      LanguageOwn(Education(50))(English),
      LanguageOwn(Education(60))(German)
    )
  )
}
