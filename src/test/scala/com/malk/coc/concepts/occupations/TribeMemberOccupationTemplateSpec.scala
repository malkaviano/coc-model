package com.malk.coc.concepts.occupations

import com.malk.coc.concepts.skills._
import com.malk.coc.traits.Skill
import com.malk.coc.concepts.skills.languages.Arabic
import com.malk.coc.helpers.SkillHelper

class TribeMemberOccupationTemplateSpec extends BehavesLikeOccupationTemplate {
  import com.malk.coc.helpers.InvestigatorCharacteristics.implicits._
  import com.malk.coc.helpers.DiceHelper.implicits._

  describe("TRIBE MEMBER occupation") {
    val occupationTemplate = new TribeMemberOccupationTemplate
    val startCreditRating = CreditRating()
    val maximumCreditRating = 15

    val fixedSkills: Set[Skill] = Set(
      Climb(),
      NaturalWorld(),
      Listen(),
      Occult(),
      SpotHidden(),
      Swim(),
      CreditRating()
    )

    val optionalSkills: Seq[(Int, Seq[(Int, Set[Skill])])] = Seq(
      (
        1,
        Seq(
          (1, Set(Sea(), Desert(), Arctic(), WildernessTerrain()))
        )
      ),
      (
        1,
        Seq(
          (
            1,
            Set(
              Axe(),
              Brawl(),
              Chainsaw(),
              Flail(),
              Garrote(),
              Spear(),
              Sword(),
              Whip(),
              Throw()
            )
          )
        )
      )
    )

    val nonTrainableSkills: Set[Skill] = Set(CthulhuMythos())

    val excludedSkills: Set[Skill] = SkillHelper.uncommonSkills ++ SkillHelper.modernSkills

    val implicitBody = body
    val implicitBrain = brain
    val implicitEdu = edu
    val implicitApp = app

    // TODO: Randomize
    val language = Arabic

    val result = occupationTemplate.templateSkills(
      implicitBody,
      implicitBrain,
      implicitEdu,
      implicitApp,
      language
    )

    val templateSkillResult = TemplateSkillResult(
      fixedSkills,
      optionalSkills,
      nonTrainableSkills,
      excludedSkills
    )

    it should behave like behavesLikeOccupationTemplate(
      occupationTemplate,
      TribeMemberOccupationTemplate.name,
      startCreditRating,
      maximumCreditRating,
      result,
      templateSkillResult
    )
  }

}
