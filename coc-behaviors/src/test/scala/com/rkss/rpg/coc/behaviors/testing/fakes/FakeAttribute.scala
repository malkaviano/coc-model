package com.rkss.rpg.coc.behaviors.testing.fakes

import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.coc.behaviors.attributes._

final case class FakeAttribute[A <: AttributeName](
    val name: A,
    override val baseValue: Int,
    override val maximum: Int
) extends DerivedAttribute[A]
    with AttributeWithValueChangeBehavior[A]
