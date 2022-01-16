package com.rkss.rpg.coc.foundations.attributes

import com.rkss.rpg.coc.concepts.EntityWithBasicRoll
import com.rkss.rpg.coc.concepts.EntityWithBaseValue
import com.rkss.rpg.coc.rules.behaviors.WithBasicRollBehavior

final case class Luck(override val baseValue: Int)
    extends EntityWithBaseValue
    with EntityWithBasicRoll
    with WithBasicRollBehavior