package com.malk.coc.concepts.skills

import com.malk.coc.traits.GenericSkill
import com.malk.coc.traits.UncommonSkill
import com.malk.coc.traits.NotPushableSkill

abstract class Lore() extends GenericSkill with UncommonSkill with NotPushableSkill {
  override val name: String = "Lore"

  override val base: Int = 1
}
