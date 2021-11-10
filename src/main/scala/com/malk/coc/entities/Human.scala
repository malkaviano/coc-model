package com.malk.coc.entities

import com.malk.coc.concepts.characteristics._
import com.malk.coc.traits._
import com.malk.coc.concepts.attributes.MovementRate
import com.malk.coc.traits.AgingEffectOnEducation
import com.malk.coc.rules.HumanMobility
import com.malk.coc.rules.HumanAgingEffectOnEducation

abstract class Human(
    private val age: Age,
    private val str: Strength,
    private val siz: Size,
    private val dex: Dexterity,
    private val con: Constitution,
    private var app: Appearance,
    private var edu: Education
)(implicit
    agingEffectOnEducation: AgingEffectOnEducation,
    movementRateGenerator: (Age, Strength, Dexterity, Size) => MovementRate,
    agingEffectOnAppearanceModifier: (Age, Appearance) => Appearance
) extends Mobility
    with PhysicalCapacity
    with Charismatic
    with Knowledge {
  edu = agingEffectOnEducation.modifiedEducation(age, edu)
  app = agingEffectOnAppearanceModifier(age, app)

  private val mov: MovementRate =
    movementRateGenerator(age, str, dex, siz)

  def Age: Int = age.value

  override def MOV: Int = mov.value

  override def STR: Int = ageInfluencePhysicalCapacity(str)

  override def CON: Int = ageInfluencePhysicalCapacity(con)

  override def DEX: Int = ageInfluencePhysicalCapacity(dex)

  override def SIZ: Int = siz.value

  override def APP: Int = app.value

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
