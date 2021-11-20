package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.BehavesLikeLanguageSkill
import com.malk.coc.concepts.skills.languages._
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.skills.languages.own.LanguageOwn

class ChineseLanguageOtherSpec extends BehavesLikeLanguageSkill {
  val skillName = "Language Other (Chinese)"

  val skill = ChineseLanguageOther()

  behavesLikeLanguageSkill(
    skill,
    skillName,
    1,
    true,
    20,
    ChineseLanguageOther(),
    EnglishLanguageOther(),
    LanguageOwn(Education(50))(Chinese),
    LanguageOwn(Education(60))(Spanish)
  )
}
