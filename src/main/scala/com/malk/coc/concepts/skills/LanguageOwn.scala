package com.malk.coc.concepts.skills

import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.traits.CharacteristicSkill
import com.malk.coc.traits.PushableSkill
import com.malk.coc.traits.WithoutBaseValueSkill

final case class LanguageOwn(edu: Education)(spent: Int)
    extends CharacteristicSkill[Education](spent)
    with PushableSkill
    with WithoutBaseValueSkill {
  override val name: String = "Language Own"

  override val base: Int = edu.value
}
