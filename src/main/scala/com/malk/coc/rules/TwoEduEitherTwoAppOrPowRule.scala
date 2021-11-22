package com.malk.coc.rules

import com.malk.coc.traits.OccupationSkillPointsRule
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints
import com.malk.coc.concepts.characteristics._
import com.malk.coc.concepts.abstractions._

final class TwoEduEitherTwoAppOrPowRule extends OccupationSkillPointsRule {
  val name = "TwoEduEitherTwoAppOrPowRule"

  override def occupationSkillPoints(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): InvestigatorSkillPoints = {
    val eduPoints = 2 * edu.value

    val otherPoints = app match {
      case x if x.value > brain.power.value => x.value
      case _ => brain.power.value
    }

    InvestigatorSkillPoints(eduPoints + (2 * otherPoints))
  }
}
