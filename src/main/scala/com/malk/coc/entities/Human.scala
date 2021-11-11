package com.malk.coc.entities

import com.malk.coc.concepts.characteristics._
import com.malk.coc.traits._
import com.malk.coc.concepts.attributes.MovementRate
import com.malk.coc.traits.AgingEffectOnEducation
import com.malk.coc.rules.HumanMobility
import com.malk.coc.rules.HumanAgingEffectOnEducation

class Human(
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
  ): Human = {
    import com.malk.coc.rules.HumanAgingEffectOnBody
    import com.malk.coc.rules.HumanAgingEffectOnEducation.implicits._
    import com.malk.coc.rules.HumanMobility._
    import com.malk.coc.rules.HumanAgingEffectOnAppearance._

    val resultBody =
      HumanAgingEffectOnBody.modifiedPhysical(age, str, con, dex, siz)

    new Human(age, resultBody._1, resultBody._4, resultBody._3, resultBody._2, app, edu)
  }
}
