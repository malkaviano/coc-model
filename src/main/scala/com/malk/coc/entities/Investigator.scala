package com.malk.coc.entities

import com.malk.coc.concepts.characteristics._
import com.malk.coc.traits._
import com.malk.coc.concepts.attributes._
import com.malk.coc.abstractions._
import com.malk.coc.rules.HumanAgingRules

class Investigator private (
    private val age: Age,
    private val body: Body,
    private val app: Appearance,
    private val edu: Education,
    private val brain: Brain,
    private val mov: MovementRate,
    private val sanity: Sanity,
    private val mp: CurrentMagicPoints,
    private val luck: Luck,
    val occupationName: String,
    val skills: Set[Skill]
) extends Chance
    with Aging
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

  override def HP: Int = body.maximumHitPoints.value

  override def Build: Int = body.build.value

  override def DB: Int = body.damageBonus.value

  override def SAN: Int = sanity.value

  override def MP: Int = mp.value

  override def Luck: Int = luck.value
}

object Investigator {
  def apply(
      age: Age,
      body: Body,
      app: Appearance,
      edu: Education,
      brain: Brain,
      luck: Luck,
      occupationName: String,
      skills: Set[Skill]
  )(implicit
      humanAgingRules: HumanAgingRules
  ): Investigator = {
    val agedBody = humanAgingRules on body

    val agedEdu = humanAgingRules on edu

    val agedAppearance = humanAgingRules on app

    val humanAgedMovementRate = humanAgingRules movFor body

    val sanity = Sanity(brain.power.value)

    val mp = CurrentMagicPoints(brain.power.value / 5)

    new Investigator(
      age,
      agedBody,
      agedAppearance,
      agedEdu,
      brain,
      humanAgedMovementRate,
      sanity,
      mp,
      luck,
      occupationName,
      skills
    )
  }
}
