package com.rkss.rpg.coc.rules.testing

import scala.collection.mutable.{Queue => MutableQueue}

import com.rkss.rpg.helpers.traits._
import com.rkss.rpg.coc.concepts.skill.roll.SkillRollDiceResult

object TestingProps {
  def fakeRng(returns: Seq[Int]): (DiceRange) => DiceResult = {
    val queue = MutableQueue.from(returns.iterator)

    (range: DiceRange) => SkillRollDiceResult(queue.dequeue())
  }
}
