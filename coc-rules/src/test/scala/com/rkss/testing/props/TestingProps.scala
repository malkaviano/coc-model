package com.rkss.testing.props

import scala.collection.mutable.{Queue => MutableQueue}

import com.rkss.rpg.helpers.traits.DiceRange
import com.rkss.rpg.helpers.traits.DiceResult

object TestingProps {
  def fakeRng(returns: Seq[Int]): (DiceRange) => DiceResult = {
    val queue = MutableQueue.from(returns.iterator)

    (range: DiceRange) => FakeDiceResult(queue.dequeue())
  }
}
