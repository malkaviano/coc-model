package com.malk.coc.entities

import com.malk.coc.concepts.attributes._
import com.malk.coc.concepts.abstractions._
import com.malk.coc.concepts.characteristics._
import com.malk.coc.concepts.dices._
import com.malk.coc.rules.HumanAgingRules
import com.malk.coc.traits.Chance

final case class Investigator private (
    private val human: Human,
    private val luck: Luck,
) extends Chance {
  override def Luck: Int = ???
}

object Investigator {
  def apply(
      age: Age,
      body: Body,
      app: Appearance,
      edu: Education,
      brain: Brain,
      luck: Luck
  )(implicit
    fourSidedDice: FourSidedDice,
    sixSidedDice: SixSidedDice,
    tenSidedDice: TenSidedDice,
    hundredSidedDice: HundredSidedDice
): Investigator = {
    // TODO: Apply investigator rules
    val sanity = Sanity(20)
    val mp = MaximumMagicPoints(40)

    val human = Human(
      age,
      body,
      app,
      edu,
      brain,
      sanity,
      mp
    )(new HumanAgingRules(age))

    new Investigator(human, luck)
  }
}
