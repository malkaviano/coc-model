package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.attributes._

final case class Age(
    initial: Int,
    max: Int = 1000
) extends Attribute(
      AgeAttribute,
      initial,
      max
    )
