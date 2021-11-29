package com.malk.coc.concepts.occupations

import com.malk.coc.concepts.skills._
import com.malk.coc.traits.Skill
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.abstractions._

class TribeMemberOccupationTemplateSpec extends BehavesLikeOccupationTemplate {
  import com.malk.coc.generators.InvestigatorCharacteristics.implicits._
  import com.malk.coc.helpers.DiceHelper.implicits._
  import com.malk.coc.generators.InvestigatorAttributes.implicits._

  val implicitBody = body
  val implicitBrain = brain
  val implicitEdu = edu
  val implicitApp = app
  val implicitLanguage = language

  val occupationTemplate = TribeMemberOccupationTemplate(
    implicitBody,
    implicitBrain,
    implicitEdu,
    implicitApp,
    implicitLanguage
  )

  describe("TRIBE MEMBER occupation") {

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

    val optionalSkills = Seq(
      OccupationTemplateChoice(
        1,
        Set(Sea(), Desert(), Arctic(), WildernessTerrain())
      ),
      OccupationTemplateChoice(
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

    val excludedSkills: Set[Skill] =
      SkillHelper.uncommonSkills ++ SkillHelper.modernSkills

    val result = occupationTemplate.templateSkills

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
