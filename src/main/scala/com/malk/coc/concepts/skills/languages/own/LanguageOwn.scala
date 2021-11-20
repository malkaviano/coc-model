package com.malk.coc.concepts.skills.languages.own

import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.traits.CharacteristicSkill
import com.malk.coc.traits.PushableSkill
import com.malk.coc.traits.WithoutBaseValueSkill
import com.malk.coc.concepts.skills.languages.Language
import com.malk.coc.concepts.skills.languages.LanguageComparison

final case class LanguageOwn(edu: Education)(override val language: Language)
    extends CharacteristicSkill[Education]
    with PushableSkill
    with WithoutBaseValueSkill
    with LanguageComparison {
  override val name: String = s"Language Own (${language})"

  override val base: Int = edu.value
}
