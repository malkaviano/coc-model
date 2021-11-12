package com.malk.coc.concepts.skills

import com.malk.coc.traits.GenericSkill
import com.malk.coc.traits.PushableSkill

abstract class ArtAndCraft(spent: Int) extends GenericSkill(spent) with PushableSkill {
  override def name: String = "Art and Craft"

  override val base: Int = 5

  override def value: Int = base + spent
}
