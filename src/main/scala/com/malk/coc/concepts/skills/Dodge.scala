package com.malk.coc.concepts.skills

import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.traits.CharacteristicSkill
import com.malk.coc.traits.NotPushableSkill
import com.malk.coc.traits.WithoutBaseValueSkill

final case class Dodge(dex: Dexterity)()
    extends CharacteristicSkill[Dexterity]
    with NotPushableSkill
    with WithoutBaseValueSkill {
  override val name: String = "Dodge"

  override val base: Int = (dex.value / 2)
}
