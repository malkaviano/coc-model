package com.malk.coc.concepts.occupations

import com.malk.coc.traits.Skill
import com.malk.coc.concepts.skills._
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.rules.TwoEduEitherTwoDexOrStrRule
import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.skills.languages.Language

final class TribeMemberOccupationTemplate private (
    override val body: Body,
    override val brain: Brain,
    override val edu: Education,
    override val app: Appearance,
    override val language: Language
) extends OccupationTemplate {
  val name = TribeMemberOccupationTemplate.name

  def startCreditRating = CreditRating(0, 15)

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

  private def fixedSkills: Set[Skill] = Set(
    Climb(),
    NaturalWorld(),
    Listen(),
    Occult(),
    SpotHidden(),
    Swim(),
    startCreditRating
  )

  private def optionalSkills: Seq[OccupationTemplateOption] = Seq(
    OccupationTemplateOption(
      1,
      Set(
        Sea(),
        Desert(),
        Arctic(),
        WildernessTerrain()
      )
    ),
    OccupationTemplateOption(
      1,
      SkillHelper.fightingSkills ++ Set(Throw())
    )
  )

  private def nonTrainableSkills: Set[Skill] = Set(CthulhuMythos())

  private def excludedSkills: Set[Skill] =
    SkillHelper.modernSkills ++ SkillHelper.uncommonSkills
}

object TribeMemberOccupationTemplate {
  val name = "TRIBE MEMBER"

  def apply(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance,
      language: Language
  ): TribeMemberOccupationTemplate = {
    new TribeMemberOccupationTemplate(body, brain, edu, app, language)
  }
}