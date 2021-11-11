package com.malk.coc.entities

import com.malk.coc.concepts.characteristics._
import com.malk.coc.traits._
import com.malk.coc.concepts.attributes.MovementRate

class Human private(
    private val age: Age,
    private val str: Strength,
    private val siz: Size,
    private val dex: Dexterity,
    private val con: Constitution,
    private val app: Appearance,
    private val edu: Education
)(implicit
    movementRateGenerator: (Age, Strength, Dexterity, Size) => MovementRate
) extends Mobility
    with PhysicalCapacity
    with Charismatic
    with Knowledge {
  private val mov: MovementRate =
    movementRateGenerator(age, str, dex, siz)

  def Age: Int = age.value

  override def MOV: Int = mov.value

  override def STR: Int = str.value

  override def CON: Int = con.value

  override def DEX: Int = dex.value

  override def SIZ: Int = siz.value

  override def APP: Int = app.value

  override def EDU: Int = edu.value
}

object Human {
  def apply(
      age: Age,
      str: Strength,
      siz: Size,
      dex: Dexterity,
      con: Constitution,
      app: Appearance,
      edu: Education
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
      )
  ): Human = {
    import com.malk.coc.rules.HumanMobility._

    val resultBody = agingEffectOnBody(age, str, con, dex, siz)

    val agedEdu = agingEffectOnEducation.modifiedEducation(age, edu)

    val agedAppearance = agingEffectOnAppearanceModifier(age, app)

    new Human(
      age,
      resultBody._1,
      resultBody._4,
      resultBody._3,
      resultBody._2,
      agedAppearance,
      agedEdu
    )
  }
}
