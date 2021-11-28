package com.malk.coc.traits

import com.malk.coc.concepts.occupations.InvestigatorSkillPoints
import com.malk.coc.concepts.abstractions._
import com.malk.coc.concepts.characteristics._

trait OccupationSkillPoints {
  def occupationSkillPoints(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): InvestigatorSkillPoints
}
