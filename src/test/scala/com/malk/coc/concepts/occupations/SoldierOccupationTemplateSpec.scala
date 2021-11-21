package com.malk.coc.concepts.occupations

import com.malk.coc.traits.Skill
import com.malk.coc.concepts.skills._
import com.malk.coc.helpers.SkillHelper
import com.malk.coc.concepts.skills.languages.English
import com.malk.coc.concepts.skills.languages.own.LanguageOwn

class SoldierOccupationTemplateSpec extends BehavesLikeOccupationTemplate {
  import com.malk.coc.helpers.InvestigatorCharacteristics.implicits._
  import com.malk.coc.helpers.DiceHelper.implicits._

  val implicitBody = body
  val implicitBrain = brain
  val implicitEdu = edu
  val implicitApp = app

  // TODO: Randomize
  val language = English

  val occupationTemplate = SoldierOccupationTemplate.apply(
    implicitBody,
    implicitBrain,
    implicitEdu,
    implicitApp,
    language
  )

  describe("SOLDIER occupation") {
    val startCreditRating = CreditRating()

    startCreditRating.spend(9)

    val fixedSkills: Set[Skill] = Set(
      Dodge(implicitBody.dexterity)(),
      Stealth(),
      startCreditRating
    )

    val optionalSkills: Seq[(Int, Seq[(Int, Set[Skill])])] = Seq(
      (1, Seq((1, Set(Climb(), Swim())))),
      (1, Seq((1, SkillHelper.fightingSkills))),
      (1, Seq((1, SkillHelper.firearmSkills))),
      (1, Seq((1, SkillHelper.survivalSkills))),
      (
        2,
        Seq(
          (1, Set(FirstAid())),
          (1, Set(MechanicalRepair())),
          (1, SkillHelper.languageOtherSkills - LanguageOwn(edu)(language))
        )
      )
    )

    val nonTrainableSkills: Set[Skill] = Set(CthulhuMythos())

    val excludedSkills: Set[Skill] =
      SkillHelper.uncommonSkills ++ SkillHelper.modernSkills

    val result = occupationTemplate.templateSkills

    val templateSkillResult = TemplateSkillResult(
      fixedSkills,
      optionalSkills,
      nonTrainableSkills,
      excludedSkills
    )

    it should behave like behavesLikeOccupationTemplate(
      occupationTemplate,
      SoldierOccupationTemplate.name,
      startCreditRating,
      30,
      result,
      templateSkillResult
    )
  }
}
