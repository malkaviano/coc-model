package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.sanity._
import com.rkss.rpg.coc.rules.sanity.behaviors._

final case class InvestigatorSanity(
    override val initial: Int
) extends Sanity with SanityBehavior with SanityRollBehavior
