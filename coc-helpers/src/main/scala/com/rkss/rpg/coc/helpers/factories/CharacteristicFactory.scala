package com.rkss.rpg.coc.helpers.factories

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.helpers.dice._

object CharacteristicFactory {
  private val rule1 = (3, 5, 0)
  private val rule2 = (2, 5, 6)

  def characteristic[A <: CharacteristicName](
      name: A,
      baseValue: Int
  ): PrimaryCharacteristic[A] = {
    PrimaryCharacteristic(name, baseValue)
  }

  def characteristic[A <: CharacteristicName](
      name: A
  )(implicit
      sixSidedDice: SixSidedDice
  ): PrimaryCharacteristic[A] = {
    val rolled = name match {
      case Strength => rollingCharacteristic(rule1._1, rule1._2, rule1._3)
      case Dexterity => rollingCharacteristic(rule1._1, rule1._2, rule1._3)
      case Constitution => rollingCharacteristic(rule1._1, rule1._2, rule1._3)
      case Appearance => rollingCharacteristic(rule1._1, rule1._2, rule1._3)
      case Power => rollingCharacteristic(rule1._1, rule1._2, rule1._3)
      case Education => rollingCharacteristic(rule2._1, rule2._2, rule2._3)
      case Intelligence => rollingCharacteristic(rule2._1, rule2._2, rule2._3)
      case Size => rollingCharacteristic(rule2._1, rule2._2, rule2._3)
    }

    characteristic(name, rolled)
  }

  private def rollingCharacteristic(
      times: Int,
      multiply: Int,
      plus: Int
  )(implicit
      sixSidedDice: SixSidedDice
  ): Int = {
    val rolled = (1 to times).fold(0)((acc, _) => sixSidedDice.roll.value + acc)

    (rolled + plus) * multiply
  }
}
