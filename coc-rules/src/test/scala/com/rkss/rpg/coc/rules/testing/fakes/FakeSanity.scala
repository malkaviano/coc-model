package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.concepts.sanity._
import com.rkss.rpg.coc.rules.sanity.behaviors._
import com.rkss.rpg.coc.concepts.characteristic._

final case class FakeSanity(
    override val initial: Characteristic[Power.type]
) extends Sanity with SanityBehavior with SanityRollBehavior
