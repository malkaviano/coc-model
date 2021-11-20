package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.Arabic

final case class ArabicLanguageOther() extends LanguageOther(Arabic) {
  override def name = s"${super.name} (Arabic)"
}