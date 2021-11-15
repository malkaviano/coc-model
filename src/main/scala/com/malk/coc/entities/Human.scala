package com.malk.coc.entities

import com.malk.coc.concepts.characteristics._
import com.malk.coc.traits._
import com.malk.coc.concepts.attributes.MovementRate
import com.malk.coc.concepts.attributes.CurrentHitPoints
import com.malk.coc.concepts.abstractions.Body
import com.malk.coc.concepts.abstractions.Brain
import com.malk.coc.concepts.attributes.Sanity
import com.malk.coc.rules.HumanAgingRules
import com.malk.coc.concepts.attributes.MaximumMagicPoints

final case class Human private (
    private val age: Age,
    private val body: Body,
    private val app: Appearance,
    private val edu: Education,
    private val brain: Brain,
    private val mov: MovementRate,
    private val sanity: Sanity,
    private val mp: MaximumMagicPoints
) extends Aging
    with Mobility
    with PhysicalCapacity
    with MentalCapacity
    with Charismatic
    with Knowledge
    with Damageable
    with FightingManeuverModifier
    with MeleeDamageBonus
    with SaneBehavior
    with Magic {

  private var currentHP = CurrentHitPoints(body.maximumHitPoints.value)

  override def Age: Int = age.value

  override def MOV: Int = mov.value

  override def STR: Int = body.strength.value

  override def CON: Int = body.constitution.value

  override def DEX: Int = body.dexterity.value

  override def SIZ: Int = body.size.value

  override def APP: Int = app.value

  override def EDU: Int = edu.value

  override def INT: Int = brain.intelligence.value

  override def POW: Int = brain.power.value

  override def HP: Int = currentHP.value

  override def HP_=(hp: Int): Unit = {
    currentHP = currentHP.copy(hp)
  }

  override def Build: Int = body.build.value

  override def DB: Int = body.damageBonus.value

  override def SAN: Int = sanity.value

  override def MP: Int = mp.value
}

object Human {
  def apply(
      age: Age,
      body: Body,
      app: Appearance,
      edu: Education,
      luck: Luck,
      brain: Brain,
      sanity: Sanity,
      mp: MaximumMagicPoints,
  )(implicit
      humanAgingRules: HumanAgingRules
  ): Human = {
    val agedBody = humanAgingRules on body

    val agedEdu = humanAgingRules on edu

    val agedAppearance = humanAgingRules on app

    val humanAgedMovementRate = humanAgingRules movFor body

    Human(
      age,
      agedBody,
      agedAppearance,
      agedEdu,
      brain,
      humanAgedMovementRate,
      sanity,
      mp
    )
  }
}
