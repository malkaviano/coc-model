package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.helpers.fixtures._
import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts.attributes._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._

final case class Sanity(
    private val power: Characteristic[Power.type],
    private val mythos: Skill[CthulhuMythos.type]
) {
  private val internal: BasicIntFixture[SanityAttribute.type] =
    BasicIntFixture(
      SanityAttribute,
      BasicIntOptions(
        power.value(),
        minimum = 0,
        maximum = 99 - mythos.value()
      )
    )

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

  def current: Int = internal.value

  def maximum: Int = internal.maximum

  def gain(
      gain: BasicIntValue[SanityAttribute.type]
  ): Unit = {
    internal.plus(gain)
  }

  def loss(
      loss: BasicIntValue[SanityAttribute.type]
  ): Unit = {
    internal.minus(loss)
  }
}
