package com.malk.coc.concepts.occupations

import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.concepts.skills.CreditRating
import com.malk.coc.concepts.abstractions.{Body, Brain}
import com.malk.coc.concepts.characteristics.{Appearance, Education}
import com.malk.coc.concepts.skills.languages.Language
import com.malk.coc.traits.Skill

/*
ZEALOT
History,
two interpersonal skills (Charm, Fast Talk, Intimidate, or Persuade),
Psychology,
Stealth,
and any three other skills.
Credit Rating: 0–30
Occupation Skill Points: EDU × 2 + either APP × 2 or POW × 2
 */

final case class ZealotTemplate() extends OccupationTemplate {
  override def name: String = ZealotTemplate.name

  override def startCreditRating: CreditRating = ???

  override def maximumCreditRating: Int = ???

  override def occupationSkillPoints(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance
  ): InvestigatorSkillPoints = ???

  override def templateSkills(
      body: Body,
      brain: Brain,
      edu: Education,
      app: Appearance,
      language: Language
  ): (Set[Skill], Seq[(Int, Seq[(Int, Set[Skill])])], Set[Skill], Set[Skill]) =
    ???

}

object ZealotTemplate {
  val name = "ZEALOT"
}