package com.rkss.testing.props

import com.rkss.rpg.helpers.traits.DiceResult

final case class FakeDiceResult(override val value: Int) extends DiceResult