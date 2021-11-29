package com.malk.coc.helpers

import scala.collection.mutable.{Set => mutableSet}
import scala.collection.immutable.Set
import scala.util.Random

import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.skills._
import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.traits.Skill
import com.malk.coc.concepts.skills.languages.other.LanguageOther
import com.malk.coc.abstractions._

final case class OccupationSkillPicker(
    val occupationTemplate: OccupationTemplate
) {
  private val pickedSkills: mutableSet[Skill] = mutableSet.empty
  private val consolidatedSkills: mutableSet[Skill] = mutableSet.empty

  val languageOwn: LanguageOwn =
    LanguageOwn(occupationTemplate.edu)(occupationTemplate.language)

  val dodge: Dodge = Dodge(occupationTemplate.body.dexterity)()

  val creditRating = occupationTemplate.startCreditRating

  val cannotSpendPointsSkills: Set[Skill] =
    occupationTemplate.templateSkills.cannotSpendPointsSkills

  val excludedSkills: Set[Skill] =
    occupationTemplate.templateSkills.excludedSkills

  occupationTemplate.templateSkills.occupationFixedSkills.foreach(skill => {
    getSkill(skill).foreach(pickedSkills.add(_))
  })

  occupationTemplate.templateSkills.occupationChooseSkills.foreach {
    case OccupationTemplateChoice(take: Int, options: Set[Skill]) => {
      val reduced =
        options -- pickedSkills -- cannotSpendPointsSkills -- excludedSkills

      Random
        .shuffle(reduced.toSeq)
        .take(take)
        .foreach(getSkill(_).foreach(pickedSkills.add(_)))
    }
  }

  val occupationSkills: Set[Skill] = pickedSkills.toSet

  def personalSkills(occupationSkills: Set[Skill]): Set[Skill] = {
    occupationSkills.foreach(getSkill(_).foreach(consolidatedSkills.add(_)))

    SkillHelper
      .filteredSkills(
        occupationTemplate.templateSkills.excludedSkills ++ occupationTemplate.templateSkills.cannotSpendPointsSkills
      )
      .foreach(getSkill(_).foreach(consolidatedSkills.add(_)))

    consolidatedSkills.toSet
  }

  private def getSkill(skill: Skill): Option[Skill] = {
    skill match {
      case x: Skill
          if occupationTemplate.templateSkills.excludedSkills.contains(x) =>
        None
      case x: Skill
          if occupationTemplate.templateSkills.cannotSpendPointsSkills.contains(
            x
          ) =>
        None
      case skill: LanguageOther
          if skill.language == occupationTemplate.language =>
        Some(languageOwn)
      case LanguageOwn(edu)   => Some(languageOwn)
      case Dodge(dex)         => Some(dodge)
      case CreditRating(i, m) => Some(creditRating)
      case anyOther           => Some(anyOther)
    }
  }
}
