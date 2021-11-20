package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.German

final case class GermanLanguageOther() extends LanguageOther(German) {
  override def name = s"${super.name} (German)"
}
