package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.coc.behaviors.attributes._

final case class Age(
    override val initial: Int,
    override val maximum: Int = 100
) extends DerivedAttribute[AgeAttribute.type]
    with AttributeWithCurrentValue
    with AttributeWithMaximumValue
    with AttributeWithValueChangeBehavior[AgeAttribute.type]
