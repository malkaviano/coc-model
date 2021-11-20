package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.Portuguese

final case class PortugueseLanguageOther() extends LanguageOther(Portuguese) {
  override def name = s"${super.name} (Portuguese)"
}
