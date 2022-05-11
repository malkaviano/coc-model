package com.rkss.rpg.coc.concepts.results

import com.rkss.rpg.helpers.traits._

final case class DiceRolled(override val value: Int) extends DiceResult
