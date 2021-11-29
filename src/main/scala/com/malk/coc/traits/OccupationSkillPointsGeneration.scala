package com.malk.coc.traits

import com.malk.coc.abstractions._
import com.malk.coc.concepts.characteristics._

trait OccupationSkillPointsGeneration {
  def occupationSkillPoints(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): SkillPoints
}
