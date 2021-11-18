package com.malk.coc.helpers

import com.malk.coc.concepts.dices._
import com.malk.coc.concepts.characteristics._
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.rules.RollRules


object InvestigatorCharacteristics {
  def randomStrength(implicit sixSidedDice: SixSidedDice): Strength = {
    Strength(RollRules.rollThreeSixSidedMultFive(sixSidedDice))
  }

  def randomConstitution(implicit sixSidedDice: SixSidedDice): Constitution = {
    Constitution(RollRules.rollThreeSixSidedMultFive(sixSidedDice))
  }

  def randomDexterity(implicit sixSidedDice: SixSidedDice): Dexterity = {
    Dexterity(RollRules.rollThreeSixSidedMultFive(sixSidedDice))
  }

  def randomAppearance(implicit sixSidedDice: SixSidedDice): Appearance = {
    Appearance(RollRules.rollThreeSixSidedMultFive(sixSidedDice))
  }

  def randomPower(implicit sixSidedDice: SixSidedDice): Power = {
    Power(RollRules.rollThreeSixSidedMultFive(sixSidedDice))
  }

  def randomSize(implicit sixSidedDice: SixSidedDice): Size = {
    Size(RollRules.rollTwoSixSidedPlusSixMultFive(sixSidedDice))
  }

  def randomIntelligence(implicit sixSidedDice: SixSidedDice): Intelligence = {
    Intelligence(RollRules.rollTwoSixSidedPlusSixMultFive(sixSidedDice))
  }

  def randomEducation(implicit sixSidedDice: SixSidedDice): Education = {
    Education(RollRules.rollTwoSixSidedPlusSixMultFive(sixSidedDice))
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
  }
}
