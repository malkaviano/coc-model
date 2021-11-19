package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.PushableSkill

final case class Climb() extends Skill with PushableSkill {
  override def base: Int = 20

  override def name: String = "Climb"
}