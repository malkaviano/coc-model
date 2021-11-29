package com.malk.coc.rules

import com.malk.coc.traits.OccupationSkillPoints
import com.malk.coc.concepts.characteristics._
import com.malk.coc.abstractions._

final class TwoEduEitherTwoAppOrPowRule extends OccupationSkillPoints {
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
