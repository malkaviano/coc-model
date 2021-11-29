package com.malk.coc.generators

import com.malk.coc.helpers.DiceHelper
import com.malk.coc.concepts.attributes.Age
import com.malk.coc.concepts.attributes.Luck
import com.malk.coc.abstractions.dices._
import com.malk.coc.rules.RollRules
import com.malk.coc.concepts.skills.languages.Language
import scala.util.Random
import com.malk.coc.concepts.skills.languages._

object InvestigatorAttributes {
  def randomAge: Age = DiceHelper.randomAge()

  def randomLuck(implicit sixSidedDice: SixSidedDice, age: Age): Luck = {
    val value = age match {
      case Age(value) if value < 20 =>
        val result1 = RollRules.rollThreeSixSidedMultFive(sixSidedDice)
        val result2 = RollRules.rollThreeSixSidedMultFive(sixSidedDice)

        if (result1 > result2) result1 else result2
      case Age(value) => RollRules.rollThreeSixSidedMultFive(sixSidedDice)
    }

    Luck(value)
  }

  def randomLanguage: Language = Random.shuffle(Seq(
      Arabic,
      English,
      German,
      Japanese,
      Portuguese,
      Spanish,
      Chinese,
      French,
      Italian,
      Polish,
      Russian,
      Turkish
    )).head

  object implicits {
    implicit def age: Age = randomAge

    implicit def luck(implicit sixSidedDice: SixSidedDice, age: Age): Luck =
      randomLuck(sixSidedDice, age)

    implicit def language: Language =
      randomLanguage
  }
}
