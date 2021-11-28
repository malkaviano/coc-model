package com.malk.coc.rules

import com.malk.coc.traits.OccupationSkillPoints
import com.malk.coc.concepts.abstractions.{Body, Brain}
import com.malk.coc.concepts.characteristics.{Appearance, Education}
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints

class FourEduRule extends OccupationSkillPoints {
  val name = "FourEduRule"

  override def occupationSkillPoints(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): InvestigatorSkillPoints = InvestigatorSkillPoints(4 * edu.value)
}
