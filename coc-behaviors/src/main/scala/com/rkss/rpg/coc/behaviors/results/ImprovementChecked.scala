package com.rkss.rpg.coc.behaviors.results

import com.rkss.rpg.coc.concepts.commons._

private[behaviors] final case class ImprovementChecked(
    rolled: DiceRolled,
    improved: Int
)
