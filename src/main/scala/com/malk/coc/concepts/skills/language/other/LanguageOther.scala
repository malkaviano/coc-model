package com.malk.coc.concepts.skills.language.other

import com.malk.coc.traits.GenericSkill
import com.malk.coc.traits.PushableSkill

abstract class LanguageOther() extends GenericSkill with PushableSkill {
  override def name: String = "Language Other"

  override val base: Int = 1
}
