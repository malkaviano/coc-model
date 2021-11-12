package com.malk.coc.concepts.skills

import com.malk.coc.traits.GenericSkill
import com.malk.coc.traits.PushableSkill

abstract class Survival(spent: Int) extends GenericSkill(spent) with PushableSkill {
  override val name: String = "Survival"

  override val base: Int = 10
}
