package com.rkss.rpg.script // Package is outside coc on purpose to check visibility

import com.rkss.rpg.coc.foundations.characteristics._
import com.rkss.rpg.coc.concepts.skill.roll._
import com.rkss.rpg.coc.foundations.skills._

object SampleUsage extends App {
  import com.rkss.rpg.helpers.dice.Bag._

  println("Sample usage of foundations")

  val strength = Strength(40)

  println(s"""${strength.name}
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

  val firstAid = FirstAid.create(40, 15)

  println(s"""${firstAid.name}
            | base value: ${firstAid.baseValue}
            | occupation points: ${firstAid.occupationPoints}
            | personal points: ${firstAid.personalPoints}
            | regular: ${firstAid.value()}
            | hard: ${firstAid.value(HardDifficulty)}
            | extreme: ${firstAid.value(ExtremeDifficulty)}
            | success check: ${firstAid.successCheck}
            | improved value: ${firstAid.improvedValue}
            """.stripMargin)

  val firstAidRollResult =
    firstAid.roll(RegularDifficulty, BonusDice(0), PenaltyDice(0))

  println(s"First Aid: ${printSkillRollResult(firstAidRollResult)}")

  val pushedFirstAidRoll = firstAid.pushRoll()

  pushedFirstAidRoll.foreach(p => {
    println(s"Pushing the First Aid: ${printSkillRollResult(p)}")
  })

  private def printSkillRollResult(skillRolled: SkillRolled): String = {
    s"""
      Base value: ${skillRolled.rollable.baseValue}
      Roll value: ${skillRolled.rollable.value(skillRolled.difficulty)}
      Difficulty: ${skillRolled.difficulty}
      Bonus dice: ${skillRolled.bonusDice}
      Penalty dice: ${skillRolled.penaltyDice}
      Rolled: ${skillRolled.rolled}
      Roll result: ${skillRolled.rollResult}
      Pushed: ${skillRolled.pushed}
    """
  }
}