package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.attributes.sanity._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts.commons._
import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.behaviors.attributes._
import com.rkss.rpg.coc.concepts.attributes._

final case class InvestigatorSanity(
    override val baseValue: Int,
    private val mythos: Skill[CthulhuMythos.type]
) extends Sanity with AttributeWithValueChangeBehavior[SanityAttribute.type] {
  override def maximum: Int = {
    99 - mythos.value()
  }

  override def roll(implicit
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
