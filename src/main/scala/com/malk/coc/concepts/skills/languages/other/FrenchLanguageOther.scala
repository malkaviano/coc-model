package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.French

final case class FrenchLanguageOther() extends LanguageOther(French) {
  override def name = s"${super.name} (French)"
}
