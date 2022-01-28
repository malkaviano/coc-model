package com.rkss.rpg.coc.rules.sanity.behaviors

import com.rkss.rpg.coc.concepts.sanity._

trait SanityBehavior { self: Sanity =>
  private var _current: Int = self.initial

  private var _maximum: Int = 99

  override def current: Int = {
    _current
  }

  override def maximum: Int = {
    _maximum
  }

  override def loss(value: Int): Unit = {
    _current -= decrease(value, _current)
  }

  override def gain(value: Int): Unit = {
    _current += Math.abs(value)

    if(current > maximum) _current = maximum
  }

  override def currentMythos(value: Int): Unit = {
    _maximum -= decrease(value, _maximum)
  }

  private def decrease(value: Int, target: Int): Int = {
    val abs = Math.abs(value)

    if (abs > target) target else abs
  }
}
