package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.English

final case class EnglishLanguageOther() extends LanguageOther(English) {
  override def name = s"${super.name} (English)"
}