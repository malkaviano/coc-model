package com.rkss.rpg.coc.behaviors.results

import com.rkss.rpg.coc.concepts.results._

private[behaviors] final case class ImprovementChecked(
    rolled: DiceRolled,
    improved: Int
)
