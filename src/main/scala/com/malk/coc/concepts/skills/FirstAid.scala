package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.PushableSkill

final case class FirstAid() extends Skill with PushableSkill {
  override def base: Int = 30

  override def name: String = "First Aid"
}