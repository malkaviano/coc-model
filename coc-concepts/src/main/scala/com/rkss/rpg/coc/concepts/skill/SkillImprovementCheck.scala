package com.rkss.rpg.coc.concepts.skill

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.helpers.traits.DiceResult

private[coc] trait SkillImprovementCheck {
  def improvementCheck(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): Option[DiceResult]
}
