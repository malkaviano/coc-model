package com.rkss.rpg.coc.rules.testing

import scala.collection.mutable.{Queue => MutableQueue}

import com.rkss.rpg.helpers.traits._
import com.rkss.rpg.coc.rules.testing.fakes._

object TestingProps {
  def fakeRng(returns: Seq[Int]): (DiceRange) => DiceResult = {
    val queue = MutableQueue.from(returns.iterator)

    (range: DiceRange) => FakeDiceResult(queue.dequeue())
  }
}
