package com.malk.coc.traits

import com.malk.coc.concepts.skills.CreditRating

trait OccupationTemplate {
  def name: String

  def startCreditRating: CreditRating

  def maximumCreditRating: CreditRating

  def fixedSkills: Seq[Skill]

  def optionalSkills: Seq[(Int, Seq[Skill])]

  def occupationSkillPointsRule: OccupationSkillPointsRule
}
