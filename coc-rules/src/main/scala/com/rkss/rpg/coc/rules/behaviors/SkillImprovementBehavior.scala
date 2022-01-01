package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.rules._
import com.rkss.rpg.helpers.traits.DiceResult

private[coc] trait SkillImprovementBehavior
    extends SkillSuccessfullyUsedBehavior {
  self: Skill
    with SkillSuccessCheck
    with SkillSuccessCheckable
    with SkillWithImprovedValue
    with SkillImprovable =>

  private var _improvedValue = 0

  override def improvedValue: Int = _improvedValue

  override def improvementCheck(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): SkillImproved = {
    successCheck match {
      case true => {
        _successCheck = false

        val result = SkillImprovement(this).result

        _improvedValue += result.improvedValue

        result
      }
      case _ => SkillImproved(this, 0, Option.empty[DiceResult], false)
    }
  }
}
