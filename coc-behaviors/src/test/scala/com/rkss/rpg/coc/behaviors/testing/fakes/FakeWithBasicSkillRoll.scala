package com.rkss.rpg.coc.behaviors.testing.fakes

import com.rkss.rpg.coc.concepts.EntityWithBasicRoll
import com.rkss.rpg.coc.behaviors._

final case class FakeWithBasicSkillRoll(override val baseValue: Int)
    extends EntityWithBasicRoll
    with WithBasicRollBehavior
