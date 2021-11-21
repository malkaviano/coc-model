package com.malk.coc.concepts.occupations

import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.concepts.abstractions.{Body, Brain}
import com.malk.coc.concepts.characteristics.{Appearance, Education}
import com.malk.coc.traits.Skill
import com.malk.coc.concepts.skills._
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.rules.TwoEduEitherTwoDexOrStrRule
import com.malk.coc.concepts.skills.languages.Language
import com.malk.coc.concepts.skills.languages.own.LanguageOwn

final class SoldierTemplate extends OccupationTemplate {
  override def name: String = SoldierTemplate.name

  override def startCreditRating: CreditRating = CreditRating(9, 30)

  override def occupationSkillPoints(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): InvestigatorSkillPoints = {
    val rule = new TwoEduEitherTwoDexOrStrRule

    rule.occupationSkillPoints(body, brain, edu, app)
  }

  override def templateSkills(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance,
      language: Language
  ): TemplateSkillResult = {
    val dodge = Dodge(body.dexterity)()

    TemplateSkillResult(
      (fixedSkills - dodge) + dodge,
      optionalSkills(language),
      nonTrainableSkills,
      excludedSkills
    )
  }

  private def fixedSkills: Set[Skill] = Set(
    Dodge(Dexterity(0))(),
    Stealth(),
    startCreditRating
  )

  private def optionalSkills(language: Language): Seq[(Int, Seq[(Int, Set[Skill])])] = Seq(
    (
      1,
      Seq(
        (
          1,
          Set(Climb(), Swim())
        )
      )
    ),
    (
      1,
      Seq(
        (
          1,
          SkillHelper.fightingSkills
        )
      )
    ),
    (
      1,
      Seq(
        (
          1,
          SkillHelper.firearmSkills
        )
      )
    ),
    (
      1,
      Seq(
        (
          1,
          SkillHelper.survivalSkills
        )
      )
    ),
    (
      2,
      Seq(
        (1, Set(FirstAid())),
        (1, Set(MechanicalRepair())),
        (1, (SkillHelper.languageOtherSkills - LanguageOwn(Education(0))(language)))
      )
    )
  )

  private def nonTrainableSkills: Set[Skill] = Set(CthulhuMythos())

  private def excludedSkills: Set[Skill] =
    SkillHelper.modernSkills ++ SkillHelper.uncommonSkills
}

object SoldierTemplate {
  val name = "SOLDIER"
}
