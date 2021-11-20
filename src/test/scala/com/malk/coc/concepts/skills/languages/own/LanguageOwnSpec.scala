package com.malk.coc.concepts.skills.languages.own

import com.malk.coc.concepts.skills.languages._
import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.skills.languages.other.ArabicLanguageOther
import com.malk.coc.concepts.skills.languages.other.EnglishLanguageOther
import com.malk.coc.concepts.skills.BehavesLikeSkill

class LanguageOwnSpec extends BehavesLikeLanguageSkill with BehavesLikeSkill {
  describe("Language Own") {
    val skillName = "Language Own (Arabic)"

    val skill = LanguageOwn(Education(50))(Arabic)

    behavesLikeSkill(
      skill,
      skillName,
      50,
      true,
      20,
    )

    checkLanguageBehavior(
      skill,
      (
        LanguageOwn(Education(50))(Arabic),
        LanguageOwn(Education(60))(German),
        ArabicLanguageOther(),
        EnglishLanguageOther()
      )
    )
  }
}
