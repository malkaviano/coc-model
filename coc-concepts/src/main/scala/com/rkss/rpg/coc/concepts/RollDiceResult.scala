package com.rkss.rpg.coc.concepts

import com.rkss.rpg.helpers.traits.DiceResult

final case class RollDiceResult(override val value: Int) extends DiceResult