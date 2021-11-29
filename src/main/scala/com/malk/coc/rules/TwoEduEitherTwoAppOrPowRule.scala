package com.malk.coc.rules

import com.malk.coc.traits.OccupationSkillPointsGeneration
import com.malk.coc.concepts.characteristics._
import com.malk.coc.abstractions._

final class TwoEduEitherTwoAppOrPowRule extends OccupationSkillPointsGeneration {
  val name = "TwoEduEitherTwoAppOrPowRule"

  override def occupationSkillPoints(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): SkillPoints = {
    val eduPoints = 2 * edu.value

    val otherPoints = app match {
      case x if x.value > brain.power.value => x.value
      case _ => brain.power.value
    }

    SkillPoints(eduPoints + (2 * otherPoints))
  }
}
