package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.NotPushableSkill
import com.malk.coc.traits.UncommonSkill

final case class Artillery(spent: Int) extends Skill(spent) with NotPushableSkill with UncommonSkill {
  override val base: Int = 1

  override val name: String = "Artillery"
}