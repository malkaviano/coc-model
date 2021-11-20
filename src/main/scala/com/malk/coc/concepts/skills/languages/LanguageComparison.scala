package com.malk.coc.concepts.skills.languages

import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.skills.languages.other.LanguageOther

trait LanguageComparison {
  val language: Language

  override def equals(other: Any): Boolean = other match {
    case l: LanguageOwn   => language == l.language
    case l: LanguageOther => language == l.language
    case _                => false
  }
}
