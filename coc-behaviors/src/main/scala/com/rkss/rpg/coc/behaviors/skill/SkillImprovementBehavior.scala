package com.rkss.rpg.coc.behaviors.skill

import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts.skill.check._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.behaviors.skill._
import com.rkss.rpg.coc.behaviors.results._
import com.rkss.rpg.coc.concepts._

private[coc] trait SkillImprovementBehavior[A <: SkillName]
    extends SkillSuccessfullyUsedBehavior {
  self: Skill[A]
    with SkillSuccessMark
    with SkillSuccessMarkable
    with SkillWithImprovement
    with SkillImprovable[A] =>

  private var _improvement = 0

  override def improvement: Int = _improvement

  override def improvementCheck(implicit
      hundredSidedDice: HundredSidedDice,
      tenSidedDice: TenSidedDice
  ): SkillImproved[A] = {
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
          Option.empty[RollDiceResult],
          false
        )
    }
  }
}
