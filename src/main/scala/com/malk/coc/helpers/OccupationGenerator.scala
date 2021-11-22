package com.malk.coc.helpers

import com.malk.coc.traits.Skill
import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints
import scala.util.Random
import com.malk.coc.concepts.occupations.TemplateSkillResult

final case class OccupationGenerator(
    private val occupationTemplate: OccupationTemplate
)(implicit private val rangeDice: ((Int, Int)) => Int) {
  private val occupationSkillPoints =
    occupationTemplate.occupationSkillPoints

  private val personalInterestPoints = InvestigatorSkillPoints(
    occupationTemplate.brain.intelligence.value * 2
  )

  private val templateSkills: TemplateSkillResult =
    occupationTemplate.templateSkills

  private val picker = OccupationSkillPicker(
    occupationTemplate
  )

  private val chosenOccupationSkills = picker.occupationSkills

  private val spentSkillPointsOnSKills: Set[Skill] = {
    spentAllPoints(
      chosenOccupationSkills.toSeq,
      occupationSkillPoints,
      15
    )

    val eligible = picker.personalSkills(chosenOccupationSkills)

    spentAllPoints(
      Random.shuffle(eligible.toSeq),
      personalInterestPoints,
      5
    )
  }

  val name: String = occupationTemplate.name

  val skills: Set[Skill] =
    spentSkillPointsOnSKills ++ templateSkills.cannotSpendPointsSkills

  val remainingPoints: Int =
    occupationSkillPoints.remaining + personalInterestPoints.remaining

  private def spentAllPoints(
      skills: Seq[Skill],
      investigatorSkillPoints: InvestigatorSkillPoints,
      maxIncrement: Int
  ): Set[Skill] = {
    while (investigatorSkillPoints.remaining > 0) {
      skills.foreach(skill => {
        val rolled = rangeDice((0, maxIncrement))

        val points = if (skill.isInstanceOf[CreditRating]) {
          if (skill.asInstanceOf[CreditRating].canSpend(rolled)) {
            rolled
          } else {
            0
          }
        } else {
          rolled
        }

        investigatorSkillPoints.spend(points)
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
