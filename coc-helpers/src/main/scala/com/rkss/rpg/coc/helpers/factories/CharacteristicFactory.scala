package com.rkss.rpg.coc.helpers.factories

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.helpers.generators._

object CharacteristicFactory {
  private val rule1 = (3, 5, 0)
  private val rule2 = (2, 5, 6)

  def characteristic[A <: CharacteristicName](
      name: A,
      baseValue: Int
  ): Characteristic[A] = {
    Characteristic(name, baseValue)
  }

  def characteristic[A <: CharacteristicName](
      name: A
  )(implicit
      sixSidedDice: SixSidedDice
  ): Characteristic[A] = {
    val rolled = name match {
      case Strength =>
        RngValuesGenerator.creationValue(rule1._1, rule1._2, rule1._3)
      case Dexterity =>
        RngValuesGenerator.creationValue(rule1._1, rule1._2, rule1._3)
      case Constitution =>
        RngValuesGenerator.creationValue(rule1._1, rule1._2, rule1._3)
      case Appearance =>
        RngValuesGenerator.creationValue(rule1._1, rule1._2, rule1._3)
      case Power =>
        RngValuesGenerator.creationValue(rule1._1, rule1._2, rule1._3)
      case Education =>
        RngValuesGenerator.creationValue(rule2._1, rule2._2, rule2._3)
      case Intelligence =>
        RngValuesGenerator.creationValue(rule2._1, rule2._2, rule2._3)
      case Size =>
        RngValuesGenerator.creationValue(rule2._1, rule2._2, rule2._3)
    }

    characteristic(name, rolled)
  }
}
