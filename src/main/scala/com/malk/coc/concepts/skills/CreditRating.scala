package com.malk.coc.concepts.skills

import com.malk.coc.traits.Skill
import com.malk.coc.traits.PushableSkill
import com.malk.coc.traits.WithoutBaseValueSkill

final case class CreditRating(val initial: Int = 0, val maximum: Int = 30)
    extends Skill
    with PushableSkill
    with WithoutBaseValueSkill {
  private var internalValue: Int = initial

  override def name: String = "Credit Rating"

  override def spend(points: Int): Unit = {
    if (internalValue + points <= maximum) {
      internalValue += points
    }
  }

  override def value: Int = internalValue
}
