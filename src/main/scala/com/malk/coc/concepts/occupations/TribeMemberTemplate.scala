package com.malk.coc.concepts.occupations

import com.malk.coc.traits.Skill
import com.malk.coc.concepts.skills._
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.rules.TwoEduEitherTwoStrOrDexRule
import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.characteristics.Dexterity

final class TribeMemberTemplate extends OccupationTemplate {
  val name = TribeMemberTemplate.name

  def startCreditRating = CreditRating()

  def maximumCreditRating = {
    val cr = CreditRating()

    cr.spend(15)

    cr
  }

  def fixedSkills: Set[Skill] = Set(
    Climb(),
    NaturalWorld(),
    Listen(),
    Occult(),
    SpotHidden(),
    Swim()
  )

  def optionalSkills: Set[(Int, Set[Skill])] = Set(
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

  def nonTrainableSkills: Set[Skill] = Set(CthulhuMythos())

  def excludedSkills: Set[Skill] =
    SkillHelper.modernSkills ++ SkillHelper.uncommonSkills

  def personalSkills: Set[Skill] = SkillHelper.filteredSkills(
    nonTrainableSkills ++ excludedSkills + Dodge(
      Dexterity(0)
    )() + LanguageOwn(Education(0))() + CreditRating()
  )

  val occupationSkillPointsRule = new TwoEduEitherTwoStrOrDexRule

  def templateSkills(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): (Set[Skill], Set[(Int, Set[Skill])], Set[Skill], Set[Skill]) = {
    val selfSkills = Set(
      Dodge(body.dexterity)(),
      LanguageOwn(edu)()
    )

    (
      fixedSkills,
      optionalSkills,
      personalSkills ++ selfSkills,
      nonTrainableSkills
    )
  }
}

object TribeMemberTemplate {
  val name = "TRIBE MEMBER"
}
