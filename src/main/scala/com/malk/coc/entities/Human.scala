package com.malk.coc.entities

import com.malk.coc.concepts.characteristics._
import com.malk.coc.traits._
import com.malk.coc.concepts.attributes.MovementRate
import com.malk.coc.concepts.attributes.HitPoints

case class Human private (
    private val age: Age,
    private val str: Strength,
    private val siz: Size,
    private val dex: Dexterity,
    private val con: Constitution,
    private val app: Appearance,
    private val edu: Education,
    private val luck: Luck,
    private val int: Intelligence,
    private val pow: Power,
    private val mov: MovementRate,
    private val hp: HitPoints
) extends Aging
    with Mobility
    with PhysicalCapacity
    with MentalCapacity
    with Charismatic
    with Knowledge
    with Chance
    with Damageable {

  override def Age: Int = age.value

  override def MOV: Int = mov.value

  override def STR: Int = str.value

  override def CON: Int = con.value

  override def DEX: Int = dex.value

  override def SIZ: Int = siz.value

  override def APP: Int = app.value

  override def EDU: Int = edu.value

  override def Luck: Int = luck.value

  override def INT: Int = int.value

  override def POW: Int = pow.value

  override def HP: Int = hp.value
}

object Human {
  def apply(
      age: Age,
      str: Strength,
      siz: Size,
      dex: Dexterity,
      con: Constitution,
      app: Appearance,
      edu: Education,
      luck: Luck,
      int: Intelligence,
      pow: Power,
  )(implicit
      agingEffectOnEducation: AgingEffectOnEducation,
      agingEffectOnAppearanceModifier: (Age, Appearance) => Appearance,
      agingEffectOnBody: (
          Age,
          Strength,
          Constitution,
          Dexterity,
          Size
      ) => (
          Strength,
          Constitution,
          Dexterity,
          Size
      ),
      movementRateGenerator: (Age, Strength, Dexterity, Size) => MovementRate
  ): Human = {
    import com.malk.coc.rules.HumanMobility._

    val agedBody = agingEffectOnBody(age, str, con, dex, siz)

    val agedEdu = agingEffectOnEducation.modifiedEducation(age, edu)

    val agedAppearance = agingEffectOnAppearanceModifier(age, app)

    val modifiedMOV =
      movementRateGenerator(age, agedBody._1, agedBody._3, agedBody._4)

    val hp = HitPoints(agedBody._2, agedBody._4)
    Human(
      age,
      agedBody._1,
      agedBody._4,
      agedBody._3,
      agedBody._2,
      agedAppearance,
      agedEdu,
      luck,
      int,
      pow,
      modifiedMOV,
      hp
    )
  }
}
