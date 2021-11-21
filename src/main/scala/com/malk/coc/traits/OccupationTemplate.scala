package com.malk.coc.traits

import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints
import com.malk.coc.concepts.occupations.TemplateSkillResult

trait OccupationTemplate {
  def name: String

  def startCreditRating: CreditRating

  def occupationSkillPoints: InvestigatorSkillPoints

  def templateSkills: TemplateSkillResult
}
