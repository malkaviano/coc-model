package com.malk.coc.concepts.skills

import com.malk.coc.traits.GenericSkill
import com.malk.coc.traits.PushableSkill

abstract class ArtAndCraft() extends GenericSkill with PushableSkill {
  override def name: String = "Art and Craft"

  override val base: Int = 5
}
