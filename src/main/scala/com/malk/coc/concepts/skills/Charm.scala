package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.PushableSkill
import com.malk.coc.traits.InterpersonalSkill

final case class Charm(spent: Int) extends Skill(spent) with InterpersonalSkill with PushableSkill {
  override def base: Int = 15

  override def name: String = "Charm"
}
