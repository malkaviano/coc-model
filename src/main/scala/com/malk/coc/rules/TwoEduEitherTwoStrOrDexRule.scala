package com.malk.coc.rules

import com.malk.coc.traits.OccupationSkillPointsRule
import com.malk.coc.concepts.occupations.OccupationSkillPoints
import com.malk.coc.concepts.characteristics._
import com.malk.coc.concepts.abstractions._

class TwoEduEitherTwoStrOrDexRule extends OccupationSkillPointsRule {
  val name = "TwoEduEitherTwoStrOrDexRule"

  override def occupationSkillPoints(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): OccupationSkillPoints = {
    val eduPoints = 2 * edu.value

    val otherPoints = body.strength match {
      case x if x.value > body.dexterity.value => x.value
      case _ => body.dexterity.value
    }

    OccupationSkillPoints(eduPoints + (2 * otherPoints))
  }
}
