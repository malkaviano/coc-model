package com.malk.coc.concepts.skills

import com.malk.coc.traits.PushableSkill
import com.malk.coc.traits.Skill

final case class Appraise(spent: Int) extends Skill(spent) with PushableSkill {
  override def base: Int = 5

  override def name: String = "Appraise"
}