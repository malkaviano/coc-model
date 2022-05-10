package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts._
import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.attributes._
import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.coc.concepts.characteristic._

final case class Sanity(
    private val power: Characteristic[Power.type],
    private val mythos: Skill[CthulhuMythos.type]
) extends DerivedAttribute[SanityAttribute.type]
    with AttributeWithCurrentValue
    with AttributeWithMaximumValue
    with AttributeWithValueChangeBehavior[SanityAttribute.type] {

  override def initial: Int = power.value()

  override def maximum: Int = {
    99 - mythos.value()
  }

  def roll(implicit
      hundredSidedDice: HundredSidedDice
  ): SanityRolled = {
    val rolled = hundredSidedDice.roll.value

    val fumble = if (this.current < 50) 96 else 100

    val result = rolled match {
      case diceResult if diceResult >= fumble       => SanityRollFumble
      case diceResult if diceResult <= this.current => SanityRollSuccessResult
      case _                                        => SanityRollFailureResult
    }

    SanityRolled(
      this.current,
      this.maximum,
      result,
      DiceRolled(rolled)
    )
  }
}
