package com.malk.coc.occupations

import com.malk.coc.traits.Skill
import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.characteristics._
import com.malk.coc.concepts.abstractions._
import com.malk.coc.helpers.SkillHelper

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

  private val creditRating = SkillHelper.spendPointsOnCreditRating(
    occupationTemplate.startCreditRating,
    occupationTemplate.maximumCreditRating,
    occupationSkillPoints
  )

  private val chosenOccupationSkills =
    occupationTemplate.fixedSkills ++ SkillHelper.chooseSkills(
      occupationTemplate.optionalSkills
    )

  private val spentSkillPoints: Set[Skill] = {
    while (occupationSkillPoints.remaining > 0) {
      chosenOccupationSkills.foreach(skill => {
        val points = occupationSkillPoints.spend(rangeDice((0, 10)))

        spendOccupationSkillPoints(skill, points)
      })
    }

    chosenOccupationSkills
  }

  val name: String = occupationTemplate.name

  val skills: Set[Skill] =
    spentSkillPoints + creditRating

  private def spendOccupationSkillPoints(
      skill: Skill,
      points: Int
  ): Skill = {
    skill.spend(points)

    skill
  }
}
