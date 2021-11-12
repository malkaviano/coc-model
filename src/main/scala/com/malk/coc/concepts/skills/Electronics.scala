package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.PushableSkill
import com.malk.coc.traits.ModernEraSkill

final case class Electronics(spent: Int) extends Skill(spent) with PushableSkill with ModernEraSkill {
  override val name: String = "Electronics"

  override val base: Int = 1
}
