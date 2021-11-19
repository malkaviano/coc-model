package com.malk.coc.concepts.skills

import com.malk.coc.traits.GenericSkill
import com.malk.coc.traits.PushableSkill

abstract class LanguageOther() extends GenericSkill with PushableSkill {
  override val name: String = "Language Other"

  override val base: Int = 1
}
