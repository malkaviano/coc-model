package com.rkss.rpg.coc.rules.testing.fakes

import com.rkss.rpg.helpers.traits.DiceResult

final case class FakeDiceResult(override val value: Int) extends DiceResult