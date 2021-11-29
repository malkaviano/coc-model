package com.malk.coc.traits

import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.abstractions.SkillPoints
import com.malk.coc.abstractions.TemplateSkillResult
import com.malk.coc.abstractions._
import com.malk.coc.concepts.characteristics.Education
import com.malk.coc.concepts.characteristics.Appearance
import com.malk.coc.concepts.skills.languages.Language

trait OccupationTemplate {
  def name: String

  def startCreditRating: CreditRating

  def occupationSkillPoints: SkillPoints

  def templateSkills: TemplateSkillResult

  def body: Body

  def brain: Brain

  def edu: Education

  def app: Appearance

  def language: Language
}
