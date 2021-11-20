package com.malk.coc.traits

import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints
import com.malk.coc.concepts.skills.languages.Language

trait OccupationTemplate {
  def name: String

  def startCreditRating: CreditRating

  def maximumCreditRating: Int

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
      app: Appearance,
      language: Language
  ): (Set[Skill], Set[(Int, Set[Skill])], Set[Skill], Set[Skill])
}
