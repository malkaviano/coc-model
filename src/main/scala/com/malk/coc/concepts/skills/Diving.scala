package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.PushableSkill
import com.malk.coc.traits.UncommonSkill

final case class Diving() extends Skill with PushableSkill with UncommonSkill {
  override val base: Int = 1

  override val name: String = "Diving"
}