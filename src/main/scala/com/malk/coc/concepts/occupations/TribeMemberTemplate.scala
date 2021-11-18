package com.malk.coc.concepts.occupations

import com.malk.coc.traits.Skill
import com.malk.coc.concepts.skills._
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.rules.TwoEduEitherTwoStrOrDexRule
import com.malk.coc.traits.Occupation

final class TribeMemberTemplate extends Occupation {
  val name = TribeMemberTemplate.name

  val startCreditRating = CreditRating(0)

  val maximumCreditRating = CreditRating(15)

  val fixedSkills: Seq[Skill] = Seq(
    Climb(0),
    NaturalWorld(0),
    Listen(0),
    Occult(0),
    SpotHidden(0),
    Swim(0)
  )

  val optionalSkills: Seq[(Int, Seq[Skill])] = Seq(
    (
      1,
      Seq(
        Sea(0),
        Desert(0),
        Arctic(0),
        WildernessTerrain(0)
      )
    ),
    (1, SkillHelper.fighting ++ Seq(Throw(0)))
  )

  val occupationSkillPointsRule = new TwoEduEitherTwoStrOrDexRule
}

object TribeMemberTemplate {
  val name = "TRIBE MEMBER"
}
