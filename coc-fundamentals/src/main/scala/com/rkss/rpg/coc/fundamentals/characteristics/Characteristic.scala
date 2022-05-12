package com.rkss.rpg.coc.fundamentals.characteristics

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals._

final case class Characteristic[A <: CharacteristicName](
    override val name: A,
    baseValue: Int
) extends BaseRollable[A](name, baseValue)
