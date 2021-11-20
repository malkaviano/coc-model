package com.malk.coc.concepts.skills.languages.other

import com.malk.coc.traits.GenericSkill
import com.malk.coc.traits.PushableSkill

import com.malk.coc.concepts.skills.languages.Language
import com.malk.coc.concepts.skills.languages.LanguageComparison

abstract class LanguageOther(override val language: Language)
    extends GenericSkill
    with PushableSkill
    with LanguageComparison {
  override def name: String = "Language Other"

  override val base: Int = 1
}
