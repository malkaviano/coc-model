package com.rkss.rpg.coc.rules.skill.behaviors

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.rules.skill._
import com.rkss.rpg.coc.concepts.skill.roll._

private[coc] trait SkillImprovementBehavior
    extends SkillSuccessfullyUsedBehavior {
  self: Skill[_]
    with SkillSuccessCheck
    with SkillSuccessCheckable
    with SkillWithImprovement
    with SkillImprovable =>

  private var _improvement = 0

  override def improvement: Int = _improvement

  override def improvementCheck(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): SkillImproved = {
    successCheck match {
      case true => {
        _successCheck = false

        val result = SkillImprovement(this).result

        _improvement += result.improvement

        result
      }
      case _ => SkillImproved(0, Option.empty[SkillRollDiceResult], false)
    }
  }
}
