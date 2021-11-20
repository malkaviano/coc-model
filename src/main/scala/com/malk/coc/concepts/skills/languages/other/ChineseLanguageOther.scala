package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.concepts.skills.languages.Chinese

final case class ChineseLanguageOther() extends LanguageOther(Chinese) {
  override def name = s"${super.name} (Chinese)"
}