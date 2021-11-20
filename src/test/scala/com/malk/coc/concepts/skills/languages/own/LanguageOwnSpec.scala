package com.malk.coc.concepts.skills.languages.own

import com.malk.coc.concepts.skills.languages._
import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.skills.languages.other.ArabicLanguageOther
import com.malk.coc.concepts.skills.languages.other.EnglishLanguageOther

class LanguageOwnSpec extends BehavesLikeLanguageSkill {
  describe("Language Own") {
    val skillName = "Language Own (Arabic)"

    val skill = LanguageOwn(Education(50))(Arabic)

    behavesLikeLanguageSkill(
      skill,
      skillName,
      50,
      true,
      20,
      LanguageOwn(Education(50))(Arabic),
      LanguageOwn(Education(60))(German),
      ArabicLanguageOther(),
      EnglishLanguageOther()
    )
  }
}
