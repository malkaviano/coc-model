package com.rkss.rpg.coc.foundations.props

import com.rkss.rpg.helpers.traits.DiceResult

final case class FakeDiceResult(override val value: Int) extends DiceResult