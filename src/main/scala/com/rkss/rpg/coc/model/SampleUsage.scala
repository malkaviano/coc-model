package com.rkss.rpg.script // Package is outside coc on purpose to check visibility

import com.rkss.rpg.coc.helpers.factories._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.foundations.actions._
import com.rkss.rpg.coc.concepts.skill.roll._

object SampleUsage extends App {
  import com.rkss.rpg.helpers.dice.Bag._

  val skillRollChecker = SkillRollAction(hundredSidedDice)

  println(
    skillRollChecker.check(
      SkillFactory.basicSkill(FirstAid, 0, 0),
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(0)
    )
  )

  val education = CharacteristicFactory.characteristic(Education)

  println(
    skillRollChecker.check(
      SkillFactory.languageOwnSkill(education, PortugueseLanguage, 0, 0),
      BonusDice(0),
      PenaltyDice(0),
      SkillFactory.basicSkill(Charm, 40, 10)
    )
  )

  val skills: Seq[SkillRollCheckable[SkillRollNaming]] = Seq(
    SkillFactory
      .basicSkill(FirstAid, 0, 0)
      .asInstanceOf[SkillRollCheckable[SkillRollNaming]],
    SkillFactory
      .languageOwnSkill(education, PortugueseLanguage, 0, 0)
      .asInstanceOf[SkillRollCheckable[SkillRollNaming]]
  )

  println(
    skillRollChecker.check(
      skills,
      RegularDifficulty,
      BonusDice(0),
      PenaltyDice(0),
      true
    )
  )

  val dexterity = CharacteristicFactory.characteristic(Dexterity)

  println(
    skillRollChecker.check(
      SkillFactory.combatSkill(Brawl, 0, 0),
      BonusDice(0),
      PenaltyDice(0),
      SkillFactory.dodgeSkill(dexterity, 0, 0),
      BonusDice(0),
      PenaltyDice(0)
    )
  )
}
