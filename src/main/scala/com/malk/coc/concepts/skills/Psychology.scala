package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.PushableSkill

final case class Psychology() extends Skill with PushableSkill {
  override def base: Int = 10

  override def name: String = "Psychology"
}