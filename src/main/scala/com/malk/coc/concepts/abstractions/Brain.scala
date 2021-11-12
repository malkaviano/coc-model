package com.malk.coc.concepts.abstractions

import com.malk.coc.concepts.characteristics.Intelligence
import com.malk.coc.concepts.characteristics.Power

final case class Brain private (characteristics: (Intelligence, Power)) {
  def intelligence: Intelligence = characteristics._1

  def power: Power = characteristics._2
}

object Brain {
  def apply(int: Intelligence, pow: Power): Brain = {
    Brain((int, pow))
  }
}