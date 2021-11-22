package com.malk.coc.concepts.occupations

import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.skills.languages.Language
import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.rules.TwoEduEitherTwoDexOrStrRule
import com.malk.coc.traits.Skill
import com.malk.coc.concepts.skills._
import com.malk.coc.helpers.SkillHelper

class PrivateInvestigatorOccupationTemplate private (
    override val body: Body,
    override val brain: Brain,
    override val edu: Education,
    override val app: Appearance,
    override val language: Language
) extends OccupationTemplate {
  override def name: String = PrivateInvestigatorOccupationTemplate.name

  override def startCreditRating: CreditRating = CreditRating(9, 30)

  override def occupationSkillPoints: InvestigatorSkillPoints = {
    val rule = new TwoEduEitherTwoDexOrStrRule

    rule.occupationSkillPoints(body, brain, edu, app)
  }

  override def templateSkills: TemplateSkillResult = {
    TemplateSkillResult(
      fixedSkills,
      optionalSkills,
      nonTrainableSkills,
      excludedSkills
    )
  }

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
}

object PrivateInvestigatorOccupationTemplate {
  val name = "PRIVATE INVESTIGATOR"

  def apply(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance,
      language: Language
  ): PrivateInvestigatorOccupationTemplate = {
    new PrivateInvestigatorOccupationTemplate(body, brain, edu, app, language)
  }
}
