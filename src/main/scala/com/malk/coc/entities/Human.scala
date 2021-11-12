package com.malk.coc.entities

import com.malk.coc.concepts.characteristics._
import com.malk.coc.traits._
import com.malk.coc.concepts.attributes.MovementRate
import com.malk.coc.concepts.attributes.MaximumHitPoints
import com.malk.coc.concepts.attributes.CurrentHitPoints
import com.malk.coc.concepts.attributes.Build
import com.malk.coc.concepts.attributes.DamageBonus
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain

case class Human private (
    private val age: Age,
    private val body: Body,
    private val app: Appearance,
    private val edu: Education,
    private val luck: Luck,
    private val brain: Brain,
    private val mov: MovementRate,
    private val maxHP: MaximumHitPoints,
    private val build: Build,
    private val db: DamageBonus
) extends Aging
    with Mobility
    with PhysicalCapacity
    with MentalCapacity
    with Charismatic
    with Knowledge
    with Chance
    with Damageable
    with FightingManeuverModifier
    with MeleeDamageBonus {

  private var currentHP = CurrentHitPoints(maxHP.value)

  override def Age: Int = age.value

  override def MOV: Int = mov.value

  override def STR: Int = body.strength.value

  override def CON: Int = body.constitution.value

  override def DEX: Int = body.dexterity.value

  override def SIZ: Int = body.size.value

  override def APP: Int = app.value

  override def EDU: Int = edu.value

  override def Luck: Int = luck.value

  override def INT: Int = brain.intelligence.value

  override def POW: Int = brain.power.value

  override def HP: Int = currentHP.value

  override def HP_=(hp: Int): Unit = {
    currentHP = currentHP.copy(hp)
  }

  override def Build: Int = build.value

  override def DB: Int = db.value
}

object Human {
  def apply(
      age: Age,
      body: Body,
      app: Appearance,
      edu: Education,
      luck: Luck,
      brain: Brain
  )(implicit
      agingEffectOnEducation: AgingEffectOnEducation,
      agingEffectOnAppearanceModifier: (Age, Appearance) => Appearance,
      agingEffectOnBody: (
          Age,
          Body
      ) => Body,
      movementRateGenerator: (Age, Strength, Dexterity, Size) => MovementRate
  ): Human = {
    val agedBody = agingEffectOnBody(age, body)

    val agedEdu = agingEffectOnEducation.modifiedEducation(age, edu)

    val agedAppearance = agingEffectOnAppearanceModifier(age, app)

    val modifiedMOV =
      movementRateGenerator(age, agedBody.strength, agedBody.dexterity, agedBody.size)

    val maxHP = MaximumHitPoints(agedBody.constitution, agedBody.size)

    val build = Build(agedBody.strength, agedBody.size)

    val db = DamageBonus(agedBody.strength, agedBody.size)

    Human(
      age,
      agedBody,
      agedAppearance,
      agedEdu,
      luck,
      brain,
      modifiedMOV,
      maxHP,
      build,
      db
    )
  }
}
