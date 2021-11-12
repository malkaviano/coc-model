package com.malk.coc.concepts.skills

import com.malk.coc.traits.PushableSkill
import com.malk.coc.traits.UncommonSkill
import com.malk.coc.traits.Skill

final case class AnimalHandling(spent: Int) extends Skill(spent) with PushableSkill with UncommonSkill {
  override val base: Int = 5

  override val name: String = "Animal Handling"
}
