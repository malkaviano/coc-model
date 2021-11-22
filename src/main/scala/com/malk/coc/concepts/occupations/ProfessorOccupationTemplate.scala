package com.malk.coc.concepts.occupations

import com.malk.coc.concepts.abstractions.{Body, Brain}
import com.malk.coc.concepts.characteristics.{Appearance, Education}
import com.malk.coc.concepts.skills.languages.Language
import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.rules.FourEduRule
import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.traits.Skill
import com.malk.coc.concepts.skills._
import com.malk.coc.helpers.SkillHelper

final class ProfessorOccupationTemplate private (
    override val body: Body,
    override val brain: Brain,
    override val edu: Education,
    override val app: Appearance,
    override val language: Language
) extends OccupationTemplate {
  override def name: String = ProfessorOccupationTemplate.name

  override def startCreditRating: CreditRating = CreditRating(20, 70)

  override def occupationSkillPoints: InvestigatorSkillPoints = {
    val rule = new FourEduRule

    rule.occupationSkillPoints(body, brain, edu, app)
  }

  override def templateSkills: TemplateSkillResult = {
    TemplateSkillResult(
      fixedSkills,
      optionalSkills(language),
      nonTrainableSkills,
      excludedSkills
    )
  }

  private def fixedSkills: Set[Skill] = Set(
    LibraryUse(),
    LanguageOwn(edu)(language),
    Psychology(),
    startCreditRating
  )

  private def optionalSkills(
      language: Language
  ): Seq[(Int, Seq[(Int, Set[Skill])])] = Seq(
    (1, Seq((1, SkillHelper.languageOtherSkills))),
    (
      4,
      Seq(
        (20, SkillHelper.allSkills)
      )
    )
  )

  private def nonTrainableSkills: Set[Skill] = Set(CthulhuMythos())

  private def excludedSkills: Set[Skill] =
    SkillHelper.uncommonSkills ++ SkillHelper.modernSkills
}

object ProfessorOccupationTemplate {
  val name = "PROFESSOR2"

  def apply(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance,
      language: Language
  ): ProfessorOccupationTemplate = {
    new ProfessorOccupationTemplate(body, brain, edu, app, language)
  }
}
