package com.malk.coc.concepts.occupations

import com.malk.coc.traits.Skill
import com.malk.coc.concepts.skills._
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.rules.TwoEduEitherTwoStrOrDexRule
import com.malk.coc.traits.OccupationTemplate

final class TribeMemberTemplate extends OccupationTemplate {
  val name = TribeMemberTemplate.name

  val startCreditRating = CreditRating()

  val maximumCreditRating = {
    val cr = CreditRating()

    cr.spend(15)

    cr
  }

  val fixedSkills: Set[Skill] = Set(
    Climb(),
    NaturalWorld(),
    Listen(),
    Occult(),
    SpotHidden(),
    Swim()
  )

  val optionalSkills: Set[(Int, Set[Skill])] = Set(
    (
      1,
      Set(
        Sea(),
        Desert(),
        Arctic(),
        WildernessTerrain()
      )
    ),
    (1, SkillHelper.fightingSkills ++ Set(Throw()))
  )

  val occupationSkillPointsRule = new TwoEduEitherTwoStrOrDexRule
}

object TribeMemberTemplate {
  val name = "TRIBE MEMBER"
}
