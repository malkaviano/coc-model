package com.rkss.rpg.coc.rules.sanity.behaviors

import com.rkss.rpg.coc.concepts.sanity._
import com.rkss.rpg.coc.concepts.skill._
import com.rkss.rpg.coc.concepts._

trait SanityBehavior { self: Sanity =>
  private var _current: Int = self.initial.value()

  private var _maximum: Int = 99

  private var _previous: Int = 0

  override def current: Int = {
    _current
  }

  override def maximum: Int = {
    _maximum
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

  override def currentMythos(
      mythos: EntityWithDifficultyValue
        with EntityWithNameTag[CthulhuMythos.type]
  ): Unit = {
    _maximum = 99 - mythos.value()
  }
}
