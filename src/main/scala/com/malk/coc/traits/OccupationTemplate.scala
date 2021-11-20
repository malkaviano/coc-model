package com.malk.coc.traits

import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints

trait OccupationTemplate {
  def name: String

  def startCreditRating: CreditRating

  def maximumCreditRating: Int

  def fixedSkills: Set[Skill]

  def optionalSkills: Set[(Int, Set[Skill])]

  def occupationSkillPoints(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): InvestigatorSkillPoints

  def templateSkills(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): (Set[Skill], Set[(Int, Set[Skill])], Set[Skill], Set[Skill])
}
