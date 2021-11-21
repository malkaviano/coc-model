package com.malk.coc.helpers

import com.malk.coc.traits.Skill
import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.characteristics._
import com.malk.coc.concepts.abstractions._
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints
import scala.util.Random
import com.malk.coc.concepts.skills.languages.Language
import com.malk.coc.concepts.occupations.TemplateSkillResult

final case class OccupationGenerator(
    private val occupationTemplate: OccupationTemplate,
    private val body: Body,
    private val brain: Brain,
    private val edu: Education,
    private val app: Appearance,
    private val language: Language
)(implicit private val rangeDice: ((Int, Int)) => Int) {
  private val occupationSkillPoints =
    occupationTemplate.occupationSkillPoints(
      body,
      brain,
      edu,
      app
    )

  private val personalInterestPoints = InvestigatorSkillPoints(
    brain.intelligence.value * 2
  )

  private val templateSkills: TemplateSkillResult =
    occupationTemplate.templateSkills(body, brain, edu, app, language)

  private val chosenOccupationSkills =
    templateSkills.occupationFixedSkills ++ SkillHelper.chooseSkillsV2(
      templateSkills.occupationChooseSkills
    )

  private val spentSkillPoints: Set[Skill] = {
    spentAllPoints(
      chosenOccupationSkills.toSeq,
      occupationSkillPoints,
      15
    )

    val eligible = chosenOccupationSkills ++ templateSkills.personalSkills

    spentAllPoints(
      Random.shuffle(eligible.toSeq),
      personalInterestPoints,
      5
    )
  }

  val name: String = occupationTemplate.name

  val skills: Set[Skill] =
    spentSkillPoints ++ templateSkills.cannotSpendPointsSkills

  val remainingPoints: Int =
    occupationSkillPoints.remaining + personalInterestPoints.remaining

  private def spentAllPoints(
      skills: Seq[Skill],
      investigatorSkillPoints: InvestigatorSkillPoints,
      maxIncrement: Int
  ): Set[Skill] = {
    while (investigatorSkillPoints.remaining > 0) {
      skills.foreach(skill => {
        val maxRange = if (skill.isInstanceOf[CreditRating]) {
          occupationTemplate.maximumCreditRating - skill.value
        } else {
          maxIncrement
        }

        val points = if (maxRange == 0) {
          0
        } else {
          investigatorSkillPoints.spend(rangeDice((0, maxRange)))
        }

        spendSkillPoints(skill, points)
      })
    }

    skills.toSet
  }

  private def spendSkillPoints(
      skill: Skill,
      points: Int
  ): Skill = {
    skill.spend(points)

    skill
  }
}
