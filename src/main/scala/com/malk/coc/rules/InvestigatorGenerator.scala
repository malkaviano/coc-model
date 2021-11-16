package com.malk.coc.rules

import com.malk.coc.concepts.dices.SixSidedDice
import com.malk.coc.concepts.characteristics._
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.dices.FourSidedDice
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.concepts.attributes.Age
import com.malk.coc.helpers.DiceHelper
import com.malk.coc.concepts.attributes.Luck

object InvestigatorGenerator {
  def randomStrength(implicit sixSidedDice: SixSidedDice): Strength = {
    Strength(rollThreeSixSidedMultFive(sixSidedDice))
  }

  def randomConstitution(implicit sixSidedDice: SixSidedDice): Constitution = {
    Constitution(rollThreeSixSidedMultFive(sixSidedDice))
  }

  def randomDexterity(implicit sixSidedDice: SixSidedDice): Dexterity = {
    Dexterity(rollThreeSixSidedMultFive(sixSidedDice))
  }

  def randomAppearance(implicit sixSidedDice: SixSidedDice): Appearance = {
    Appearance(rollThreeSixSidedMultFive(sixSidedDice))
  }

  def randomPower(implicit sixSidedDice: SixSidedDice): Power = {
    Power(rollThreeSixSidedMultFive(sixSidedDice))
  }

  def randomSize(implicit sixSidedDice: SixSidedDice): Size = {
    Size(rollTwoSixSidedPlusSixMultFive(sixSidedDice))
  }

  def randomIntelligence(implicit sixSidedDice: SixSidedDice): Intelligence = {
    Intelligence(rollTwoSixSidedPlusSixMultFive(sixSidedDice))
  }

  def randomEducation(implicit sixSidedDice: SixSidedDice): Education = {
    Education(rollTwoSixSidedPlusSixMultFive(sixSidedDice))
  }

  def randomBody(implicit
      str: Strength,
      con: Constitution,
      dex: Dexterity,
      siz: Size,
      fourSidedDice: FourSidedDice,
      sixSidedDice: SixSidedDice
  ): Body = {
    Body(str, con, dex, siz)(fourSidedDice, sixSidedDice)
  }

  def randomBrain(implicit
      int: Intelligence,
      pow: Power
  ): Brain = {
    Brain(int, pow)
  }

  def randomAge: Age = DiceHelper.randomAge()

  def randomLuck(implicit sixSidedDice: SixSidedDice, age: Age): Luck = {
    val value = age match {
      case Age(value) if value < 20 =>
        val result1 = rollThreeSixSidedMultFive(sixSidedDice)
        val result2 = rollThreeSixSidedMultFive(sixSidedDice)

        if (result1 > result2) result1 else result2
      case Age(value) => rollThreeSixSidedMultFive(sixSidedDice)
    }

    Luck(value)
  }

  private def rollThreeSixSidedMultFive(sixSidedDice: SixSidedDice): Int = {
    (1 to 3 map (_ => sixSidedDice.roll) reduce (_ + _)) * 5
  }

  private def rollTwoSixSidedPlusSixMultFive(
      sixSidedDice: SixSidedDice
  ): Int = {
    ((1 to 2 map (_ => sixSidedDice.roll) reduce (_ + _)) + 6) * 5
  }

  object implicits {
    implicit def str(implicit sixSidedDice: SixSidedDice): Strength =
      randomStrength(sixSidedDice)
    implicit def dex(implicit sixSidedDice: SixSidedDice): Dexterity =
      randomDexterity(sixSidedDice)
    implicit def con(implicit sixSidedDice: SixSidedDice): Constitution =
      randomConstitution(sixSidedDice)
    implicit def siz(implicit sixSidedDice: SixSidedDice): Size = randomSize(
      sixSidedDice
    )
    implicit def int(implicit sixSidedDice: SixSidedDice): Intelligence =
      randomIntelligence(
        sixSidedDice
      )
    implicit def pow(implicit sixSidedDice: SixSidedDice): Power = randomPower(
      sixSidedDice
    )
    implicit def app(implicit sixSidedDice: SixSidedDice): Appearance =
      randomAppearance(
        sixSidedDice
      )
    implicit def edu(implicit sixSidedDice: SixSidedDice): Education =
      randomEducation(
        sixSidedDice
      )
    implicit def body(implicit
        fourSidedDice: FourSidedDice,
        sixSidedDice: SixSidedDice
    ): Body = randomBody(
      str,
      con,
      dex,
      siz,
      fourSidedDice,
      sixSidedDice
    )
    implicit def brain(implicit
        sixSidedDice: SixSidedDice
    ): Brain = randomBrain(
      int,
      pow
    )
    implicit def age: Age = randomAge
    implicit def luck(implicit sixSidedDice: SixSidedDice, age: Age): Luck = randomLuck(sixSidedDice, age)
  }
}
