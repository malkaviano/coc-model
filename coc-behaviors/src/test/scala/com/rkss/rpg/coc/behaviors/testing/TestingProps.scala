package com.rkss.rpg.coc.behaviors.testing

import scala.collection.mutable.{Queue => MutableQueue}

import com.rkss.rpg.helpers.dice._
import com.rkss.rpg.coc.concepts.results._

object TestingProps {
  def fakeRng(returns: Seq[Int]): (DiceRange) => DiceResult = {
    val queue = MutableQueue.from(returns.iterator)

    (range: DiceRange) => SkillRollDiceResult(queue.dequeue())
  }
}
