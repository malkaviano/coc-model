package com.malk.coc.traits

import com.malk.coc.concepts.skills.CreditRating

trait OccupationTemplate {
  def name: String

  def startCreditRating: CreditRating

  def maximumCreditRating: CreditRating

  def fixedSkills: Set[Skill]

  def optionalSkills: Set[(Int, Set[Skill])]

  def occupationSkillPointsRule: OccupationSkillPointsRule
}
