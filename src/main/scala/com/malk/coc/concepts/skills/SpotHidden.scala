package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.PushableSkill

final case class SpotHidden(spent: Int) extends Skill(spent) with PushableSkill {
  override def base: Int = 25

  override def name: String = "Spot Hidden"
}