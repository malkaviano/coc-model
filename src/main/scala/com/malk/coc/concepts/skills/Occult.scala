package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.PushableSkill

final case class Occult() extends Skill with PushableSkill {
  override def base: Int = 5

  override def name: String = "Occult"
}