package com.malk.coc.concepts.skills

import com.malk.coc.traits.GenericSkill
import com.malk.coc.traits.PushableSkill

abstract class LanguageOther(spent: Int) extends GenericSkill(spent) with PushableSkill {
  override val name: String = "Language Other"

  override val base: Int = 1
}
