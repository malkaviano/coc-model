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
    with SkillSuccessMark
    with SkillSuccessMarkable
    with SkillWithImprovement
    with SkillImprovable =>

  private var _improvement = 0

  override def improvement: Int = _improvement

  override def improvementCheck(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): SkillImproved = {
    wasSuccessfullyUsed match {
      case true => {
        _wasSuccessfullyUsed = false

        val result = SkillImprovement(this).result

        _improvement += result.improvement

        result
      }
      case _ =>
        SkillImproved(
          this.name,
          this.value(),
          0,
          Option.empty[SkillRollDiceResult],
          false
        )
    }
  }
}
