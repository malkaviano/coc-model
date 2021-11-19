package com.malk.coc.concepts.skills

import com.malk.coc.traits.GenericSkill
import com.malk.coc.traits.PushableSkill

abstract class Pilot() extends GenericSkill with PushableSkill {
  override val name: String = "Pilot"

  override val base: Int = 1
}
