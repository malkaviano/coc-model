package com.rkss.rpg.script // Package is outside coc on purpose to check visibility

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.fundamentals.skills._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.coc.concepts.characteristic._

object SampleUsage extends App {
  import com.rkss.rpg.helpers.dice.Bag._

  private def printSkill(skill: Skill): Unit = {
    println(s"""
       | name: ${skill.name}
       | base value: ${skill.baseValue}
       | modified: ${skill.modificationValue}
       | regular: ${skill.value()}
       | hard: ${skill.value(HardDifficulty)}
       | extreme: ${skill.value(ExtremeDifficulty)}
       | tags: ${skill.tags}
      """.stripMargin)

    if (skill.isInstanceOf[SkillWithImprovedValue])
      println(s"""
       | improved: ${skill.asInstanceOf[SkillWithImprovedValue].improvedValue}
      """.stripMargin)
  }

  println("Sample usage of fundamentals")

  val firstAid = SkillFactory.basicSkill(FirstAid, 10, 15)

  firstAid.checkUsedWithSuccess()

  val improvement = firstAid.improvementCheck

  println(improvement)

  val improvement2 = firstAid.improvementCheck

  println(improvement2)

  firstAid.checkUsedWithSuccess()

  val improvement3 = firstAid.improvementCheck

  println(improvement3)

  val improvement4 = firstAid.improvementCheck

  println(improvement4)

  printSkill(firstAid)

  val rolled = firstAid.roll(RegularDifficulty, BonusDice(1))

  println(rolled)

  val pushed = firstAid.pushRoll(Some(HardDifficulty), penaltyDice = Some(PenaltyDice(1)))

  println(pushed)

  val brawl = SkillFactory.combatSkill(Brawl, 20, 5)

  printSkill(brawl)

  val dodge = SkillFactory.dodgeSkill(50, 10, 15)

  printSkill(dodge)

  val portugueseLanguage = SkillFactory.languageSkill(PortugueseLanguage, 10, 15)

  printSkill(portugueseLanguage)

  val japaneseLanguage = SkillFactory.languageSkill(55, JapaneseLanguage, 0, 0)

  printSkill(japaneseLanguage)

  val strength = Characteristic(Strength, 50)

  println(strength.roll())

  println(strength.pushRoll(Some(HardDifficulty)))
}
