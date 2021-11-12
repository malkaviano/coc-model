package com.malk.coc.concepts.skills

import com.malk.coc.traits.GenericSkill
import com.malk.coc.traits.WithoutBaseValueSkill
import com.malk.coc.traits.NotPushableSkill

abstract class Fighting(spent: Int)
    extends GenericSkill(spent)
    with WithoutBaseValueSkill
    with NotPushableSkill {
  override def name: String = "Fighting"
}
