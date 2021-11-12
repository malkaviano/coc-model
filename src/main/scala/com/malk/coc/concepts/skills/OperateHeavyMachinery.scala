package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.PushableSkill

final case class OperateHeavyMachinery(spent: Int) extends Skill(spent) with PushableSkill {
  override def base: Int = 1

  override def name: String = "Operate Heavy Machinery"
}