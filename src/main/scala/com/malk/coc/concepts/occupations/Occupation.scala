package com.malk.coc.occupations

import com.malk.coc.traits.Skill
import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.characteristics._
import com.malk.coc.concepts.abstractions._
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.concepts.skills.CthulhuMythos
import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints
import com.malk.coc.concepts.skills.Dodge
import com.malk.coc.concepts.skills.LanguageOwn
import scala.util.Random

final case class Occupation(
    private val occupationTemplate: OccupationTemplate,
    private val body: Body,
    private val brain: Brain,
    private val edu: Education,
    private val app: Appearance
)(implicit private val rangeDice: ((Int, Int)) => Int) {
  private val occupationSkillPoints =
    occupationTemplate.occupationSkillPointsRule.occupationSkillPoints(
      body,
      brain,
      edu,
      app
    )

  private val personalInterestPoints = InvestigatorSkillPoints(
    brain.intelligence.value * 2
  )

  private val creditRating = SkillHelper.spendPointsOnCreditRating(
    occupationTemplate.startCreditRating,
    occupationTemplate.maximumCreditRating,
    occupationSkillPoints
  )

  private val chosenOccupationSkills =
    occupationTemplate.fixedSkills ++ SkillHelper.chooseSkills(
      occupationTemplate.optionalSkills
    )

  private val reservedSkills =
    SkillHelper.allSkills -- chosenOccupationSkills - CthulhuMythos() - CreditRating() - Dodge(
      Dexterity(0)
    )() - LanguageOwn(
      Education(0)
    )() -- SkillHelper.modernSkills -- SkillHelper.uncommonSkills

  private val spentSkillPoints: Set[Skill] = {
    spentAllPoints(
      chosenOccupationSkills.toSeq,
      occupationSkillPoints,
      15
    )

    val eligible = chosenOccupationSkills ++ reservedSkills

    spentAllPoints(
      Random.shuffle(eligible.toSeq),
      personalInterestPoints,
      5
    )
  }

  val name: String = occupationTemplate.name

  // FIXME: Credit Rating is eligible to personal points.
  val skills: Set[Skill] =
    spentSkillPoints + CthulhuMythos() + creditRating

  private def spentAllPoints(
      skills: Seq[Skill],
      investigatorSkillPoints: InvestigatorSkillPoints,
      maxIncrement: Int
  ): Set[Skill] = {
    while (investigatorSkillPoints.remaining > 0) {
      skills.foreach(skill => {
        val points = investigatorSkillPoints.spend(rangeDice((0, maxIncrement)))

        spendOccupationSkillPoints(skill, points)
      })
    }

    skills.toSet
  }

  private def spendOccupationSkillPoints(
      skill: Skill,
      points: Int
  ): Skill = {
    skill.spend(points)

    skill
  }
}
