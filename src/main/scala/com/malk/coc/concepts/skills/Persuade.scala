package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.PushableSkill
import com.malk.coc.traits.InterpersonalSkill

final case class Persuade(spent: Int) extends Skill(spent) with InterpersonalSkill with PushableSkill {
  override def base: Int = 10

  override def name: String = "Persuade"
}