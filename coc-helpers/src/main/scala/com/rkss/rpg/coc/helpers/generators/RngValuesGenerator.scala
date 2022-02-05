package com.rkss.rpg.coc.helpers.generators

import com.rkss.rpg.helpers.dice._

object RngValuesGenerator {
  def creationValue(
      times: Int,
      multiply: Int,
      plus: Int
  )(implicit
      sixSidedDice: SixSidedDice
  ): Int = {
    val rolled = (1 to times).fold(0)((acc, _) => sixSidedDice.roll.value + acc)

    (rolled + plus) * multiply
  }
}
