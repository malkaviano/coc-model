package com.malk.coc.concepts.skills

import com.malk.coc.traits.GenericSkill
import com.malk.coc.traits.PushableSkill

abstract class Science() extends GenericSkill with PushableSkill {
  override def name: String = "Science"

  override def base: Int = 1
}
