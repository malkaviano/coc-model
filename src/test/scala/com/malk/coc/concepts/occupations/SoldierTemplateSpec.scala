package com.malk.coc.concepts.occupations

import com.malk.coc.traits.Skill
import com.malk.coc.concepts.skills._
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.concepts.skills.languages.English
import com.malk.coc.concepts.skills.languages.own.LanguageOwn

class SoldierTemplateSpec extends BehavesLikeOccupationTemplate {
  import com.malk.coc.helpers.InvestigatorCharacteristics.implicits._
  import com.malk.coc.helpers.DiceHelper.implicits._

  val implicitBody = body
  val implicitBrain = brain
  val implicitEdu = edu
  val implicitApp = app

  val occupationTemplate = new SoldierTemplate
  describe("SOLDIER occupation") {
    val startCreditRating = CreditRating()

    startCreditRating.spend(9)

    val fixedSkills: Set[Skill] = Set(
      Dodge(implicitBody.dexterity)(),
      Stealth()
    )

    val optionalSkills: Set[(Int, Set[Skill])] = Set(
      (1, Set(Climb(), Swim())),
      (1, SkillHelper.fightingSkills),
      (1, SkillHelper.firearmSkills),
      (1, SkillHelper.survivalSkills),
      (2, Set(FirstAid(), MechanicalRepair() /* Language Other*/ ))
    )

    val nonTrainableSkills: Set[Skill] = Set(CthulhuMythos())

    val excludedSkills = SkillHelper.uncommonSkills ++ SkillHelper.modernSkills

    // TODO: Randomize
    val language = English

    val personalSkills: Set[Skill] = SkillHelper.filteredSkills(
      nonTrainableSkills ++ excludedSkills + LanguageOwn(implicitEdu)(language) + Dodge(
        implicitBody.dexterity
      )()
    ) + LanguageOwn(implicitEdu)(language)

    val result = occupationTemplate.templateSkills(
        implicitBody,
        implicitBrain,
        implicitEdu,
        implicitApp,
        language
      )

    it should behave like behavesLikeOccupationTemplate(
      occupationTemplate,
      SoldierTemplate.name,
      startCreditRating,
      30,
      result,
      fixedSkills,
      optionalSkills,
      personalSkills,
      nonTrainableSkills
    )
  }
}
