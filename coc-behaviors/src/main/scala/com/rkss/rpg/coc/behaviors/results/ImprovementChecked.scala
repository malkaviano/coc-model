package com.rkss.rpg.coc.behaviors.results

import com.rkss.rpg.coc.concepts._

private[behaviors] final case class ImprovementChecked(
    rolled: RollDiceResult,
    improved: Int
)
