package com.rkss.rpg.script // Package is outside coc on purpose to check visibility

import com.rkss.rpg.coc.helpers.factories._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.foundations.actions._
import com.rkss.rpg.coc.concepts.skill.roll._

object SampleUsage extends App {
  import com.rkss.rpg.helpers.dice.Bag._

  val skillRollChecker = new SkillRollChecker

  skillRollChecker.skillRollCheck(
    SkillFactory.basicSkill(FirstAid, 0, 0),
    RegularDifficulty,
    BonusDice(0),
    PenaltyDice(0)
  )

  // Opposed skill roll NPC, non combat
  val education = CharacteristicFactory.characteristic(Education)

  skillRollChecker.skillRollCheck(
    SkillFactory.languageOwnSkill(education, PortugueseLanguage, 0, 0),
    BonusDice(0),
    PenaltyDice(0),
    SkillFactory.cthulhuMythosSkill,
    Seq.empty[Skill[_]]
  )

  // Combined skill rolls
  val skills: Seq[Skill[SkillName]] = Seq(
    SkillFactory.basicSkill(FirstAid, 0, 0).asInstanceOf[Skill[SkillName]],
    SkillFactory
      .languageOwnSkill(education, PortugueseLanguage, 0, 0)
      .asInstanceOf[Skill[SkillName]]
  )

  skillRollChecker.skillRollCheck(
    skills,
    RegularDifficulty,
    BonusDice(0),
    PenaltyDice(0),
    true
  )

  // val dexterity = CharacteristicFactory.characteristic(Dexterity)

  // skillRollCheck(SkillFactory.dodgeSkill(dexterity, 0, 0))

  // skillRollCheck(
  //   SkillFactory.combatSkill(Brawl, 0, 0)
  // )
}
