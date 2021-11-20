package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.Japanese

final case class JapaneseLanguageOther() extends LanguageOther(Japanese) {
  override def name = s"${super.name} (Japanese)"
}
