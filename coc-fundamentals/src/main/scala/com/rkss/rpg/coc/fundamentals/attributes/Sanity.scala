package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.helpers._
import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.helpers.basicint._
import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._
import com.rkss.rpg.coc.fundamentals._
import com.rkss.rpg.coc.concepts.skill._

final case class Sanity(
    private val power: Characteristic[Power.type],
    private val mythos: BaseRollable[CthulhuMythos.type]
) extends Attribute(SanityAttribute, power.value(), 99 - mythos.value()) {
  private def mythosChanged(event: BasicIntEvent): Unit = {
    if (event.target == BasicIntTargetValue)
      internal.maximum = 99 - event.current
  }

  EventHub.addListener(mythos.id, this.id, mythosChanged)

  def roll(implicit
      hundredSidedDice: HundredSidedDice
  ): SanityRolled = {
    val rolled = hundredSidedDice.roll.value

    val fumble = if (internal.value < 50) 96 else 100

    val result = rolled match {
      case diceResult if diceResult >= fumble         => SanityRollFumble
      case diceResult if diceResult <= internal.value => SanityRollSuccessResult
      case _                                          => SanityRollFailureResult
    }

    SanityRolled(
      internal.value,
      this.maximum,
      result,
      DiceRolled(rolled)
    )
  }
}
