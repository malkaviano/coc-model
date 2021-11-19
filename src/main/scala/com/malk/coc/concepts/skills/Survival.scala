package com.malk.coc.concepts.skills

import com.malk.coc.traits.GenericSkill
import com.malk.coc.traits.PushableSkill

abstract class Survival() extends GenericSkill with PushableSkill {
  override def name: String = "Survival"

  override val base: Int = 10
}
