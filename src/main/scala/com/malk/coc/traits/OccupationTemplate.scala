package com.malk.coc.traits

import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.concepts.occupations.InvestigatorSkillPoints
import com.malk.coc.concepts.occupations.TemplateSkillResult
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.skills.languages.Language

trait OccupationTemplate {
  def name: String

  def startCreditRating: CreditRating

  def occupationSkillPoints: InvestigatorSkillPoints

  def templateSkills: TemplateSkillResult

  def body: Body

  def brain: Brain

  def edu: Education

  def app: Appearance

  def language: Language
}
