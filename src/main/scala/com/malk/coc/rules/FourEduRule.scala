package com.malk.coc.rules

import com.malk.coc.traits.OccupationSkillPoints
import com.malk.coc.abstractions._
import com.malk.coc.concepts.characteristics.{Appearance, Education}

class FourEduRule extends OccupationSkillPoints {
  val name = "FourEduRule"

  override def occupationSkillPoints(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): SkillPoints = SkillPoints(4 * edu.value)
}
