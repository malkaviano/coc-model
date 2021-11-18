package com.malk.coc.traits

import com.malk.coc.concepts.occupations.OccupationSkillPoints
import com.malk.coc.concepts.abstractions._
import com.malk.coc.concepts.characteristics._

trait OccupationSkillPointsRule {
  def occupationSkillPoints(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): OccupationSkillPoints
}
