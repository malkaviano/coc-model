package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.coc.concepts.sanity._
import com.rkss.rpg.coc.rules.sanity.behaviors._

final case class FakeSanity(
    override val initial: Int
) extends Sanity with SanityBehavior with SanityRollBehavior
