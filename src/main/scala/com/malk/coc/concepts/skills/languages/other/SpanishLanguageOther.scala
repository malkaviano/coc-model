package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.Spanish

final case class SpanishLanguageOther() extends LanguageOther(Spanish) {
  override def name = s"${super.name} (Spanish)"
}
