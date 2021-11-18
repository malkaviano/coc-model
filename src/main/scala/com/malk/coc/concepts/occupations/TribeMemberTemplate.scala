package com.malk.coc.concepts.occupations

import com.malk.coc.traits.Skill
import com.malk.coc.concepts.skills._
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.rules.TwoEduEitherTwoStrOrDexRule
import com.malk.coc.traits.OccupationTemplate

final class TribeMemberTemplate extends OccupationTemplate {
  val name = TribeMemberTemplate.name

  val startCreditRating = CreditRating(0)

  val maximumCreditRating = CreditRating(15)

  val fixedSkills: Set[Skill] = Set(
    Climb(0),
    NaturalWorld(0),
    Listen(0),
    Occult(0),
    SpotHidden(0),
    Swim(0)
  )

  val optionalSkills: Set[(Int, Set[Skill])] = Set(
    (
      1,
      Set(
        Sea(0),
        Desert(0),
        Arctic(0),
        WildernessTerrain(0)
      )
    ),
    (1, SkillHelper.fighting ++ Set(Throw(0)))
  )

  val occupationSkillPointsRule = new TwoEduEitherTwoStrOrDexRule
}

object TribeMemberTemplate {
  val name = "TRIBE MEMBER"
}
