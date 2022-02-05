package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.EntityWithBasicRoll
import com.rkss.rpg.coc.concepts.EntityWithBaseValue
import com.rkss.rpg.coc.behaviors._

final case class Luck(override val baseValue: Int)
    extends EntityWithBaseValue
    with EntityWithBasicRoll
    with WithBasicRollBehavior
