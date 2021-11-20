package com.malk.coc.concepts.occupations

import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.concepts.abstractions.{Body, Brain}
import com.malk.coc.concepts.characteristics.{Appearance, Education}
import com.malk.coc.traits.Skill
import com.malk.coc.concepts.skills._
import com.malk.coc.concepts.characteristics.Dexterity
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.rules.TwoEduEitherTwoStrOrDexRule

final class SoldierTemplate extends OccupationTemplate {
  override def name: String = SoldierTemplate.name

  override def startCreditRating: CreditRating = {
    val cr = CreditRating()

    cr.spend(9)

    cr
  }

  override def maximumCreditRating: Int = 30

  override def occupationSkillPoints(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): InvestigatorSkillPoints = {
    val rule = new TwoEduEitherTwoStrOrDexRule

    rule.occupationSkillPoints(body, brain, edu, app)
  }

  override def templateSkills(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): (Set[Skill], Set[(Int, Set[Skill])], Set[Skill], Set[Skill]) = {
     val dodge = Dodge(body.dexterity)()

     val languageOwn = LanguageOwn(edu)()

    (
      (fixedSkills - dodge) + dodge,
      optionalSkills,
      (personalSkills - dodge -languageOwn) + languageOwn,
      nonTrainableSkills
    )
  }

  private def fixedSkills: Set[Skill] = Set(
    Dodge(Dexterity(0))(),
    Stealth()
  )

  private def optionalSkills: Set[(Int, Set[Skill])] = Set(
    (1, Set(Climb(), Swim())),
    (1, SkillHelper.fightingSkills),
    (1, SkillHelper.firearmSkills),
    (1, SkillHelper.survivalSkills),
    // Choose one Language Other and put it on the list, otherwise it will be weird polyglots soldiers.
    (2, Set(FirstAid(), MechanicalRepair() /* TODO: 1 x Language Other */ ))
  )

  private def nonTrainableSkills: Set[Skill] = Set(CthulhuMythos())

  private def excludedSkills: Set[Skill] =
    SkillHelper.modernSkills ++ SkillHelper.uncommonSkills

  private def personalSkills: Set[Skill] = SkillHelper.filteredSkills(
    nonTrainableSkills ++ excludedSkills
  )
}

object SoldierTemplate {
  val name = "SOLDIER"
}
