package com.rkss.rpg.coc.fundamentals.attributes

import com.rkss.rpg.coc.concepts.characteristic._
import com.rkss.rpg.coc.fundamentals.characteristics._

final case class Build(
    private val strength: Characteristic[Strength.type],
    private val size: Characteristic[Size.type]
) {
  def current: Int = {
    strength.value() + size.value() match {
      case x if x < 65  => -2
      case x if x < 85  => -1
      case x if x < 125 => 0
      case x if x < 165 => 1
      case x if x < 205 => 2
      case x if x < 285 => 3
      case x if x < 365 => 4
      case x if x < 445 => 5
      case x if x < 525 => 6
      case x =>
        val y = x - 524
        (y / 80.0).ceil.toInt + 6
    }
  }
}
