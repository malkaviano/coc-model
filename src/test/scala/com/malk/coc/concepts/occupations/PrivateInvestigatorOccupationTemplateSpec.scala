package com.malk.coc.concepts.occupations

import com.malk.coc.concepts.skills._
import com.malk.coc.traits.Skill
import com.malk.coc.helpers.SkillHelper

/*
one interpersonal skill (Charm, Fast Talk, Intimidate, or Persuade),

and any one other skill

*/

class PrivateInvestigatorOccupationTemplateSpec extends BehavesLikeOccupationTemplate {
  import com.malk.coc.helpers.InvestigatorCharacteristics.implicits._
  import com.malk.coc.helpers.InvestigatorAttributes.implicits._
  import com.malk.coc.helpers.DiceHelper.implicits._

  val implicitBody = body
  val implicitBrain = brain
  val implicitEdu = edu
  val implicitApp = app
  val implicitLanguage = language

  val occupationTemplate = PrivateInvestigatorOccupationTemplate(
    implicitBody,
    implicitBrain,
    implicitEdu,
    implicitApp,
    implicitLanguage
  )

  describe("PRIVATE INVESTIGATOR occupation") {
    val startCreditRating = CreditRating(9, 30)

    val fixedSkills: Set[Skill] = Set(
      Law(),
      LibraryUse(),
      Photography(),
      Psychology(),
      Disguise(),
      SpotHidden(),
      startCreditRating
    )

    val optionalSkills: Seq[(Int, Seq[(Int, Set[Skill])])] = Seq(
      (1, Seq((1, SkillHelper.interpersonalSkills))),
      (
        1,
        Seq(
          (10, SkillHelper.allSkills),
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
      PrivateInvestigatorOccupationTemplate.name,
      startCreditRating,
      30,
      result,
      templateSkillResult
    )
  }
}
