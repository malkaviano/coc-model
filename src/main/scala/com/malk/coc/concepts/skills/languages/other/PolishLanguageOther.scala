package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.Polish

final case class PolishLanguageOther() extends LanguageOther(Polish) {
  override def name = s"${super.name} (Polish)"
}
