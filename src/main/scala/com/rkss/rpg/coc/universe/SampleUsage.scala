package com.rkss.rpg.script // Package is outside coc on purpose to check visibility

import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.foundations.skills._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.improvement._

object SampleUsage extends App {
  import com.rkss.rpg.helpers.dice.Bag._

  private def printSkill(skill: Skill): Unit = {
    println(s"""
       | base value: ${skill.baseValue}
       | modified: ${skill.modificationValue}
       | regular: ${skill.value()}
       | hard: ${skill.value(HardDifficulty)}
       | extreme: ${skill.value(ExtremeDifficulty)}
      """.stripMargin)

    if (skill.isInstanceOf[SkillWithImprovedValue])
      println("improved:" + skill.asInstanceOf[SkillWithImprovedValue].improvedValue)
  }

  println("Sample usage of foundations")

  val firstAid = BasicSkill(30, 10, 15)

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
}
