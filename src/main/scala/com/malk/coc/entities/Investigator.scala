package com.malk.coc.entities

import com.malk.coc.concepts.attributes._
import com.malk.coc.concepts.abstractions._
import com.malk.coc.concepts.characteristics._
import com.malk.coc.concepts.dices._
import com.malk.coc.rules.HumanAgingRules
import com.malk.coc.traits._

final case class Investigator private (
    private val human: Human,
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
  override def Luck: Int = ???

  override def MP: Int = ???

  override def Age: Int = ???

  override def MOV: Int = ???

  override def STR: Int = ???

  override def CON: Int = ???

  override def SIZ: Int = ???

  override def DEX: Int = ???

  override def INT: Int = ???

  override def POW: Int = ???

  override def APP: Int = ???

  override def EDU: Int = ???

  override def HP: Int = ???

  override def Build: Int = ???

  override def DB: Int = ???

  override def SAN: Int = ???

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
      fourSidedDice: FourSidedDice,
      sixSidedDice: SixSidedDice,
      tenSidedDice: TenSidedDice,
      hundredSidedDice: HundredSidedDice
  ): Investigator = {
    val sanity = Sanity(brain.power.value)

    val mp = CurrentMagicPoints(brain.power.value / 5)

    val human = Human(
      age,
      body,
      app,
      edu,
      brain,
      sanity,
      mp
    )(new HumanAgingRules(age))

    new Investigator(human, luck, occupationName, skills)
  }
}
