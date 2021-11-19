package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.PushableSkill
import com.malk.coc.traits.WithoutBaseValueSkill

final case class CthulhuMythos() extends Skill with PushableSkill with WithoutBaseValueSkill {
  override def name: String = "Cthulhu Mythos"
}