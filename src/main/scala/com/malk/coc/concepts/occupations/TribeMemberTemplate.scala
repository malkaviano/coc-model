package com.malk.coc.concepts.occupations

import com.malk.coc.traits.Skill
import com.malk.coc.concepts.skills._
import com.malk.coc.concepts.skills.languages.own._
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.rules.TwoEduEitherTwoStrOrDexRule
import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.skills.languages.Language

final class TribeMemberTemplate extends OccupationTemplate {
  val name = TribeMemberTemplate.name

  def startCreditRating = CreditRating()

  def maximumCreditRating = 15

  def occupationSkillPoints(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): InvestigatorSkillPoints = {
    val rule = new TwoEduEitherTwoStrOrDexRule

    rule.occupationSkillPoints(body, brain, edu, app)
  }

  def excludedSkills: Set[Skill] =
    SkillHelper.modernSkills ++ SkillHelper.uncommonSkills

  def templateSkills(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance,
      language: Language
  ): (Set[Skill], Set[(Int, Set[Skill])], Set[Skill], Set[Skill]) = {
    val selfSkills = Set(
      Dodge(body.dexterity)(),
      LanguageOwn(edu)(language)
    )

    (
      fixedSkills,
      optionalSkills,
      (personalSkills -- selfSkills) ++ selfSkills,
      nonTrainableSkills
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

  private def optionalSkills: Set[(Int, Set[Skill])] = Set(
    (
      1,
      Set(
        Sea(),
        Desert(),
        Arctic(),
        WildernessTerrain()
      )
    ),
    (1, SkillHelper.fightingSkills ++ Set(Throw()))
  )

  private def nonTrainableSkills: Set[Skill] = Set(CthulhuMythos())

  private def personalSkills: Set[Skill] = SkillHelper.filteredSkills(
    nonTrainableSkills ++ excludedSkills
  )
}

object TribeMemberTemplate {
  val name = "TRIBE MEMBER"
}
