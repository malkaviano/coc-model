package com.rkss.rpg.script // Package is outside coc on purpose to check visibility

import com.rkss.rpg.coc.foundations.characteristics._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.foundations.skills._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.skill.improvement._
import com.rkss.rpg.coc.concepts._

object SampleUsage extends App {
  import com.rkss.rpg.helpers.dice.Bag._

  private def printSkillRollResult(skillRolled: SkillRolled): String = {
    s"""
      | Base value: ${skillRolled.rollable.baseValue}
      | Roll value: ${skillRolled.rollable.value(skillRolled.difficulty)}
      | Difficulty: ${skillRolled.difficulty}
      | Bonus dice: ${skillRolled.bonusDice}
      | Penalty dice: ${skillRolled.penaltyDice}
      | Rolled: ${skillRolled.rolled}
      | Roll result: ${skillRolled.rollResult}
      | Pushed: ${skillRolled.pushed}
    """.stripMargin
  }

  private def printSkill(skill: Skill): Unit = {
    println(s"""${skill.id}
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

  val strength = AnyCharacteristic(CharacteristicStrength, 40)

  strength.modify(10)

  println(s"""${strength.id}
              | regular: ${strength.value()}
              | hard: ${strength.value(HardDifficulty)}
              | extreme: ${strength.value(ExtremeDifficulty)}
            """.stripMargin)

  val strengthSkillRollResult =
    strength.roll(RegularDifficulty, BonusDice(0), PenaltyDice(0))

  println(s"Strength roll: ${printSkillRollResult(strengthSkillRollResult)}")

  val pushedStrengthRoll = strength.pushRoll()

  pushedStrengthRoll.foreach(p => {
    println(s"Pushing the strength: ${printSkillRollResult(p)}")
  })

  val firstAid = FirstAid.create(10, 15)

  val firstAidRollResult =
    firstAid.roll(RegularDifficulty, BonusDice(1), PenaltyDice(0))

  println(s"First Aid roll: ${printSkillRollResult(firstAidRollResult)}")

  val pushedFirstAidRoll = firstAid.pushRoll(bonusDice = Option(BonusDice(0)))

  pushedFirstAidRoll.foreach(p => {
    println(s"Pushing the First Aid roll: ${printSkillRollResult(p)}")
  })

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

  val accounting = Accounting.create(10, 15)

  accounting.modify(5)

  printSkill(accounting)

  val accountingRollResult =
    accounting.roll(RegularDifficulty, BonusDice(0), PenaltyDice(0))

  println(s"Accounting roll: ${printSkillRollResult(accountingRollResult)}")

  val pushedAccountingRoll = accounting.pushRoll()

  pushedAccountingRoll.foreach(p => {
    println(s"Pushing the Accounting roll: ${printSkillRollResult(p)}")
  })

  // val cr = CreditRating.create(10, 15)

  // printSkill(cr)
}
