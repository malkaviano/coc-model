package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.coc.behaviors.attributes._

final case class HumanAge(override val initial: Int)
    extends Age
    with AttributeWithValueChangeBehavior[AgeAttribute.type] {
  override val maximum: Int = 200
}
