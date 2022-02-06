package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.attributes.sanity._
import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.helpers.dice.HundredSidedDice
import com.rkss.rpg.coc.concepts.commons._
import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.coc.concepts.skill._

final case class InvestigatorSanity(
    private val power: Characteristic[Power.type],
    private val mythos: Skill[CthulhuMythos.type]
) extends Sanity {
  private var _current: Int = power.value()

  private var _previous: Int = 0

  override def current: Int = {
      if(_current > maximum) {
        _current = maximum
      }

      _current
  }

  override def maximum: Int = {
    99 - mythos.value()
  }

  override def loss(loss: SanityLoss): SanityLost = {
    _previous = current

    val decrease = if (loss.loss > current) current else loss.loss

    _current -= decrease

    SanityLost(decrease, current, _previous)
  }

  override def gain(gain: SanityGain): SanityRecovered = {
    _previous = current

    val delta = maximum - current

    val increase = if (gain.gain > delta) delta else gain.gain

    _current += increase

    SanityRecovered(increase, current, _previous, maximum)
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
