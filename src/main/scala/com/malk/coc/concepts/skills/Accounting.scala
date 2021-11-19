package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.PushableSkill

final case class Accounting() extends Skill with PushableSkill {
  override def base: Int = 5

  override def name: String = "Accounting"
}