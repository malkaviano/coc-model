package com.malk.coc.entities

import com.malk.coc.concepts.characteristics._
import com.malk.coc.traits._
import com.malk.coc.concepts.attributes.MovementRate
import com.malk.coc.traits.AgingEffectOnEducation
import com.malk.coc.rules.HumanMobility
import com.malk.coc.rules.HumanAgingEffectOnEducation

abstract class Human(
    protected val age: Age,
    protected val str: Strength,
    protected val siz: Size,
    protected val dex: Dexterity,
    protected val con: Constitution,
    protected val app: Appearance,
    protected var edu: Education
)(implicit
    agingEffectOnEducation: AgingEffectOnEducation,
    movementRateGenerator: (Age, Strength, Dexterity, Size) => MovementRate
) extends Mobility
    with PhysicalCapacity
    with Charismatic
    with Knowledge {
  edu = agingEffectOnEducation.modifiedEducation(age, edu)

  protected val mov: MovementRate =
    movementRateGenerator(age, str, dex, siz)

  def Age: Int = age.value

  override def MOV: Int = mov.value

  override def STR: Int = ageInfluencePhysicalCapacity(str)

  override def CON: Int = ageInfluencePhysicalCapacity(con)

  override def DEX: Int = ageInfluencePhysicalCapacity(dex)

  override def SIZ: Int = siz.value

  override def APP: Int = {
    if (age.value < 40) {
      app.value
    } else {
      val x = age.value - 40

      app.value - ((x / 10) + 1) * 5
    }
  }

  override def EDU: Int = edu.value

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
