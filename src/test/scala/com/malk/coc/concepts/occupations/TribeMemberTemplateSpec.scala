package com.malk.coc.concepts.occupations

import com.malk.coc.concepts.skills._
import com.malk.coc.concepts.skills.languages.own._
import com.malk.coc.traits.Skill
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.concepts.skills.languages.Arabic

class TribeMemberTemplateSpec extends BehavesLikeOccupationTemplate {
  import com.malk.coc.helpers.InvestigatorCharacteristics.implicits._
  import com.malk.coc.helpers.DiceHelper.implicits._

  describe("TRIBE MEMBER occupation") {
    val occupationTemplate = new TribeMemberTemplate
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

    val optionalSkills: Set[(Int, Set[Skill])] = Set(
      (1, Set(Sea(), Desert(), Arctic(), WildernessTerrain())),
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

    val nonTrainableSkills: Set[Skill] = Set(CthulhuMythos())

    val excludedSkills = SkillHelper.uncommonSkills ++ SkillHelper.modernSkills

    val implicitBody = body
    val implicitBrain = brain
    val implicitEdu = edu
    val implicitApp = app

    // TODO: Randomize
    val language = Arabic

    val selfSkills = Set(
      Dodge(implicitBody.dexterity)(),
      LanguageOwn(implicitEdu)(language)
    )

    val personalSkills: Set[Skill] = SkillHelper.filteredSkills(
      nonTrainableSkills ++ excludedSkills ++ selfSkills
    ) ++ selfSkills

    val result = occupationTemplate.templateSkills(
      implicitBody,
      implicitBrain,
      implicitEdu,
      implicitApp,
      language
    )

    it should behave like behavesLikeOccupationTemplate(
      occupationTemplate,
      TribeMemberTemplate.name,
      startCreditRating,
      maximumCreditRating,
      result,
      fixedSkills,
      optionalSkills,
      personalSkills,
      nonTrainableSkills
    )
  }

}
