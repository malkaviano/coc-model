package com.malk.coc.helpers

import scala.collection.mutable.{Set => mutableSet}
import scala.collection.immutable.Set

import com.malk.coc.concepts.skills.languages.own.LanguageOwn
import com.malk.coc.concepts.skills._
import com.malk.coc.traits.OccupationTemplate
import com.malk.coc.traits.Skill
import scala.util.Random

final case class OccupationSkillPicker(
    val occupationTemplate: OccupationTemplate
) {
  private val pickedSkills: mutableSet[Skill] = mutableSet.empty

  val languageOwn: LanguageOwn =
    LanguageOwn(occupationTemplate.edu)(occupationTemplate.language)

  val dodge: Dodge = Dodge(occupationTemplate.body.dexterity)()

  val creditRating = occupationTemplate.startCreditRating

  occupationTemplate.templateSkills.occupationFixedSkills.foreach(skill => {
    addSkill(skill)
  })

  occupationTemplate.templateSkills.occupationChooseSkills.foreach {
    case (take: Int, options: Seq[(Int, Set[Skill])]) => {
      val firstPick = options.flatMap {
        case (take: Int, options: Set[Skill]) => {
          val reduced = options -- pickedSkills

          Random.shuffle(reduced.toSeq).take(take)
        }
      }

      Random.shuffle(firstPick.toSeq).take(take).foreach(pickedSkills.add(_))
    }
  }

  def occupationSkills: Set[Skill] = pickedSkills.toSet

  private def addSkill(skill: Skill): Unit = {
    skill match {
      case LanguageOwn(edu)   => pickedSkills.add(languageOwn)
      case Dodge(dex)         => pickedSkills.add(dodge)
      case CreditRating(i, m) => pickedSkills.add(creditRating)
      case anyOther           => pickedSkills.add(anyOther)
    }
  }
}
