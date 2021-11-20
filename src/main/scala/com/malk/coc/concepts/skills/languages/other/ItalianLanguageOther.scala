package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.Italian

final case class ItalianLanguageOther() extends LanguageOther(Italian) {
  override def name = s"${super.name} (Italian)"
}
