package com.malk.coc.concepts.occupations

import com.malk.coc.concepts.skills._
import com.malk.coc.traits.Skill
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.concepts.skills.languages.own.LanguageOwn

class ProfessorOccupationTemplateSpec extends BehavesLikeOccupationTemplate {
  import com.malk.coc.helpers.InvestigatorCharacteristics.implicits._
  import com.malk.coc.helpers.InvestigatorAttributes.implicits._
  import com.malk.coc.helpers.DiceHelper.implicits._

  val implicitBody = body
  val implicitBrain = brain
  val implicitEdu = edu
  val implicitApp = app

  val occupationTemplate = ProfessorOccupationTemplate(
    implicitBody,
    implicitBrain,
    implicitEdu,
    implicitApp,
    language
  )

  describe("PROFESSOR occupation") {
    val startCreditRating = CreditRating(20, 70)

    val fixedSkills: Set[Skill] = Set(
      LibraryUse(),
      LanguageOwn(implicitEdu)(language),
      Psychology(),
      startCreditRating
    )

    val optionalSkills: Seq[(Int, Seq[(Int, Set[Skill])])] = Seq(
      (1, Seq((1, SkillHelper.languageOtherSkills))),
      (
        4,
        Seq(
          (20, SkillHelper.allSkills),
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
      ProfessorOccupationTemplate.name,
      startCreditRating,
      70,
      result,
      templateSkillResult
    )
  }
}
