package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.PushableSkill

final case class Track(spent: Int) extends Skill(spent) with PushableSkill {
  override def base: Int = 10

  override def name: String = "Track"
}