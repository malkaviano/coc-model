package com.malk.coc.generators

import scala.util.Random

import com.malk.coc.traits.Skill
import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.abstractions._
import com.malk.coc.helpers.OccupationSkillPicker
import com.malk.coc.abstractions.dices.DiceRange
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.skills.languages.Language

final class OccupationGenerator(
    private val body: Body,
    private val brain: Brain,
    private val edu: Education,
    private val app: Appearance,
    private val language: Language,
    private val occupationTemplate: OccupationTemplate
)(implicit private val rangeDice: (DiceRange) => Int) {
  private val occupationSkillPoints: SkillPoints =
    occupationTemplate.occupationSkillPoints(
      body,
      brain,
      edu,
      app,
      language
    )

  private val personalInterestPoints = SkillPoints(
    brain.intelligence.value * 2
  )

  private val picker = OccupationSkillPicker(
    body,
    brain,
    edu,
    app,
    language,
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
    spentSkillPointsOnSKills ++ picker.cannotSpendPointsSkills

  val remainingPoints: Int =
    occupationSkillPoints.remaining + personalInterestPoints.remaining

  private def spentAllPoints(
      skills: Seq[Skill],
      investigatorSkillPoints: SkillPoints,
      maxIncrement: Int
  ): Set[Skill] = {
    while (investigatorSkillPoints.remaining > 0) {
      skills.foreach(skill => {
        val rolled = rangeDice(DiceRange(0, maxIncrement))

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
