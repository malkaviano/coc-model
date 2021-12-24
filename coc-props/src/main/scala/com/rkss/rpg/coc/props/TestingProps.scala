package com.rkss.rpg.coc.props

import scala.collection.mutable.{Queue => MutableQueue}

import com.rkss.rpg.helpers.traits.DiceRange
import com.rkss.rpg.helpers.traits.DiceResult
import com.rkss.rpg.coc.props.fakes._

object TestingProps {
  def fakeRng(returns: Seq[Int]): (DiceRange) => DiceResult = {
    val queue = MutableQueue.from(returns.iterator)

    (range: DiceRange) => FakeDiceResult(queue.dequeue())
  }
}
