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
  ): OccupationSkillPoints = ???
}
