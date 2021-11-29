package com.malk.coc.rules

import com.malk.coc.traits.OccupationSkillPointsGeneration
import com.malk.coc.concepts.characteristics._
import com.malk.coc.abstractions._

final class TwoEduEitherTwoDexOrStrRule extends OccupationSkillPointsGeneration {
  val name = "TwoEduEitherTwoStrOrDexRule"

  override def occupationSkillPoints(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): SkillPoints = {
    val eduPoints = 2 * edu.value

    val otherPoints = body.strength match {
      case x if x.value > body.dexterity.value => x.value
      case _ => body.dexterity.value
    }

    SkillPoints(eduPoints + (2 * otherPoints))
  }
}
