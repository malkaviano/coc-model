package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.PushableSkill
import com.malk.coc.traits.UncommonSkill

final case class Demolitions(spent: Int) extends Skill(spent) with PushableSkill with UncommonSkill {
  override val base: Int = 1

  override val name: String = "Demolitions"
}