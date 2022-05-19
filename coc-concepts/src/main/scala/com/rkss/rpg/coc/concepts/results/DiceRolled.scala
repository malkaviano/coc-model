package com.rkss.rpg.coc.concepts.results

import com.rkss.rpg.helpers.dice._

final case class DiceRolled(override val value: Int) extends DiceResult
