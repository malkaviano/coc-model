package com.malk.coc.entities

import com.malk.coc.concepts.characteristics._
import com.malk.coc.traits._
import com.malk.coc.concepts.attributes.MovementRate

abstract class Human(
    protected val age: Age,
    protected val str: Strength,
    protected val siz: Size,
    protected val dex: Dexterity,
    protected val con: Constitution,
    protected val app: Appearance
) extends Mobility
    with PhysicalCapacity
    with Charismatic {
  protected val mov: MovementRate = MovementRate(str, dex, siz)

  override def MOV: Int = {
    val x = (age.value - 40)

    if (x < 0)
      mov.value
    else
      mov.value - ((x / 10) + 1)
  }

  def STR: Int = ageInfluencePhysicalCapacity(str)

  def CON: Int = ageInfluencePhysicalCapacity(con)

  def DEX: Int = ageInfluencePhysicalCapacity(dex)

  def SIZ: Int = siz.value

  def APP: Int = {
    if (age.value < 40) {
      app.value
    } else {
      val x = age.value - 40

      app.value - ((x / 10) + 1) * 5
    }
  }

  private def ageInfluencePhysicalCapacity(char: Characteristic) =
    age.value match {
      case x if x >= 80 => (char.value * 0.45).toInt
      case x if x >= 70 => (char.value * 0.65).toInt
      case x if x >= 60 => (char.value * 0.85).toInt
      case x if x >= 50 => (char.value * 0.9).toInt
      case x if x >= 40 => (char.value * 0.95).toInt
      case _            => char.value
    }
}
