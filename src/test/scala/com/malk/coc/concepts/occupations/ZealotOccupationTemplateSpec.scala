package com.malk.coc.concepts.occupations

import com.malk.coc.concepts.skills._
import com.malk.coc.traits.Skill
import com.malk.coc.helpers.SkillHelper

class ZealotOccupationTemplateSpec extends BehavesLikeOccupationTemplate {
  import com.malk.coc.helpers.InvestigatorCharacteristics.implicits._
  import com.malk.coc.helpers.DiceHelper.implicits._
  import com.malk.coc.helpers.InvestigatorAttributes.implicits._

  val implicitBody = body
  val implicitBrain = brain
  val implicitEdu = edu
  val implicitApp = app
  val implicitLanguage = language

  val occupationTemplate = ZealotOccupationTemplate(
    implicitBody,
    implicitBrain,
    implicitEdu,
    implicitApp,
    implicitLanguage
  )

  describe("ZEALOT occupation") {
    val startCreditRating = CreditRating(0, 30)

    val nonTrainableSkills: Set[Skill] = Set(CthulhuMythos())

    val excludedSkills: Set[Skill] =
      SkillHelper.uncommonSkills ++ SkillHelper.modernSkills

    val fixedSkills: Set[Skill] = Set(
      History(),
      Psychology(),
      Stealth(),
      startCreditRating
    )

    val optionalSkills: Seq[(Int, Seq[(Int, Set[Skill])])] = Seq(
      (
        2,
        Seq(
          (
            4,
            SkillHelper.interpersonalSkills
          )
        )
      ),
      (
        3,
        Seq(
          (
            15,
            SkillHelper.allSkills
          )
        )
      )
    )

    val result = occupationTemplate.templateSkills

    val templateSkillResult = TemplateSkillResult(
      fixedSkills,
      optionalSkills,
      nonTrainableSkills,
      excludedSkills
    )

    it should behave like behavesLikeOccupationTemplate(
      occupationTemplate,
      ZealotOccupationTemplate.name,
      startCreditRating,
      30,
      result,
      templateSkillResult
    )
  }
}
