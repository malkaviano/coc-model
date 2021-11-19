package com.malk.coc.concepts.skills

import com.malk.coc.traits.GenericSkill
import com.malk.coc.traits.WithoutBaseValueSkill
import com.malk.coc.traits.NotPushableSkill

abstract class Firearm()
    extends GenericSkill
    with WithoutBaseValueSkill
    with NotPushableSkill {
  override def name: String = "Firearm"
}
