package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.Turkish

final case class TurkishLanguageOther() extends LanguageOther(Turkish) {
  override def name = s"${super.name} (Turkish)"
}
