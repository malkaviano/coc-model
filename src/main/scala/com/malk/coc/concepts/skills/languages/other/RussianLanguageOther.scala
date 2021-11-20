package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.Russian

final case class RussianLanguageOther() extends LanguageOther(Russian) {
  override def name = s"${super.name} (Russian)"
}
