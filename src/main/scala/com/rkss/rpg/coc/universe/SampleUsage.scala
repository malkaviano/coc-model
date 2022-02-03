package com.rkss.rpg.script // Package is outside coc on purpose to check visibility

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.helpers.factories._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.coc.concepts.characteristic._

object SampleUsage extends App {
  import com.rkss.rpg.helpers.dice.Bag._

  private def printSkill(skill: Skill[_]): Unit = {
    println(s"""
       | name: ${skill.name}
       | base value: ${skill.baseValue}
       | modified: ${skill.modificationValue}
       | regular: ${skill.value()}
       | hard: ${skill.value(HardDifficulty)}
       | extreme: ${skill.value(ExtremeDifficulty)}
       | tags: ${skill.tags}
      """.stripMargin)

    if (skill.isInstanceOf[SkillWithImprovement])
      println(s"""
       | improved: ${skill.asInstanceOf[SkillWithImprovement].improvement}
      """.stripMargin)
  }

  println("Sample usage of fundamentals")

  val firstAid = SkillFactory.basicSkill(FirstAid, 10, 15)

  firstAid.markUsedWithSuccess()

  val improvement = firstAid.improvementCheck

  println(improvement)

  val improvement2 = firstAid.improvementCheck

  println(improvement2)

  firstAid.markUsedWithSuccess()

  val improvement3 = firstAid.improvementCheck

  println(improvement3)

  val improvement4 = firstAid.improvementCheck

  println(improvement4)

  printSkill(firstAid)

  val rolled = firstAid.roll(RegularDifficulty, BonusDice(1))

  println(rolled)

  val pushed =
    firstAid.pushRoll(Some(HardDifficulty), penaltyDice = Some(PenaltyDice(1)))

  println(pushed)

  val brawl = SkillFactory.combatSkill(Brawl, 20, 5)

  printSkill(brawl)

  val dodge = SkillFactory.dodgeSkill(PrimaryCharacteristic(Dexterity, 50), 10, 15)

  printSkill(dodge)

  val portugueseLanguage =
    SkillFactory.languageOtherSkill(PortugueseLanguage, 10, 15)

  printSkill(portugueseLanguage)

  val japaneseLanguage = SkillFactory.languageOwnSkill(
    PrimaryCharacteristic(Education, 55),
    JapaneseLanguage,
    0,
    0
  )

  printSkill(japaneseLanguage)

  val strength = PrimaryCharacteristic(Strength, 50)

  println(strength.roll())

  println(strength.pushRoll(Some(HardDifficulty)))

  val education = PrimaryCharacteristic(Education, 60)

  println(education)

  println(education.value())

  println(education.modificationValue)

  println(education.roll())

  println(education.value())

  println(education.modificationValue)

  val mythos = SkillFactory.cthulhuMythosSkill

  printSkill(mythos)

  val creditRating = SkillFactory.creditRatingSkill(20, 10, 0)

  printSkill(creditRating)
}
