package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.PushableSkill

final case class Intimidate(spent: Int)
    extends Skill(spent)
    with PushableSkill {
  override def base: Int = 15

  override def name: String = "Intimidate"
}
