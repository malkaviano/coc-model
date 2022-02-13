package com.rkss.rpg.script // Package is outside coc on purpose to check visibility

import com.rkss.rpg.coc.helpers.factories._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.foundations.actions._
import com.rkss.rpg.coc.concepts.skill.roll._

object SampleUsage extends App {
  import com.rkss.rpg.helpers.dice.Bag._

  val skillRollChecker = new SkillRollChecker

  println(
    skillRollChecker.skillRollCheck(
      SkillFactory.basicSkill(FirstAid, 0, 0),
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(0)
    )
  )

  val education = CharacteristicFactory.characteristic(Education)

  println(
    skillRollChecker.skillRollCheck(
      SkillFactory.languageOwnSkill(education, PortugueseLanguage, 0, 0),
      BonusDice(0),
      PenaltyDice(0),
      SkillFactory.basicSkill(Charm, 40, 10),
      Seq(
        SkillFactory.languageOtherSkill(SpanishLanguage, 10, 0),
        SkillFactory.basicSkill(Archaeology, 10, 0),
      )
    )
  )

  val skills: Seq[Skill[SkillName]] = Seq(
    SkillFactory.basicSkill(FirstAid, 0, 0).asInstanceOf[Skill[SkillName]],
    SkillFactory
      .languageOwnSkill(education, PortugueseLanguage, 0, 0)
      .asInstanceOf[Skill[SkillName]]
  )

  println(
    skillRollChecker.skillRollCheck(
      skills,
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(0),
      true
    )
  )

  val dexterity = CharacteristicFactory.characteristic(Dexterity)

  println(
    skillRollChecker.skillRollCheck(
      SkillFactory.combatSkill(Brawl, 0, 0),
      BonusDice(0),
      PenaltyDice(0),
      SkillFactory.dodgeSkill(dexterity, 0, 0),
      BonusDice(0),
      PenaltyDice(0)
    )
  )
}
