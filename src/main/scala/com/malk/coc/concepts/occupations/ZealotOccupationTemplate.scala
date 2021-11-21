package com.malk.coc.concepts.occupations

import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.concepts.abstractions.{Body, Brain}
import com.malk.coc.concepts.characteristics.{Appearance, Education}
import com.malk.coc.concepts.skills.languages.Language
import com.malk.coc.rules.TwoEduEitherTwoAppOrPowRule
import com.malk.coc.traits.Skill
import com.malk.coc.concepts.skills._
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.concepts.skills.languages.own.LanguageOwn

class ZealotOccupationTemplate extends OccupationTemplate {
  override def name: String = "ZEALOT"

  override def startCreditRating: CreditRating = CreditRating(0, 30)

  override def occupationSkillPoints(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): InvestigatorSkillPoints = {
    val rule = new TwoEduEitherTwoAppOrPowRule

    rule.occupationSkillPoints(body, brain, edu, app)
  }

  override def templateSkills(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance,
      language: Language
  ): TemplateSkillResult = {
    TemplateSkillResult(
      fixedSkills,
      optionalSkills(language),
      nonTrainableSkills,
      excludedSkills
    )
  }

  private def fixedSkills: Set[Skill] = Set(
    History(),
    Psychology(),
    Stealth(),
    startCreditRating
  )

  private def optionalSkills(
      language: Language
  ): Seq[(Int, Seq[(Int, Set[Skill])])] = Seq(
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
          SkillHelper.filteredSkills(
            fixedSkills ++ nonTrainableSkills ++ excludedSkills ++ SkillHelper.interpersonalSkills + LanguageOwn(
              Education(0)
            )(language)
          )
        )
      )
    )
  )

  private def nonTrainableSkills: Set[Skill] = Set(CthulhuMythos())

  private def excludedSkills: Set[Skill] =
    SkillHelper.modernSkills ++ SkillHelper.uncommonSkills
}

object ZealotOccupationTemplate {
  val name = "ZEALOT"
}