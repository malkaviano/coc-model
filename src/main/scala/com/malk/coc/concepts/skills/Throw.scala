package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.NotPushableSkill

final case class Throw(spent: Int) extends Skill(spent) with NotPushableSkill {
  override def base: Int = 20

  override def name: String = "Throw"
}