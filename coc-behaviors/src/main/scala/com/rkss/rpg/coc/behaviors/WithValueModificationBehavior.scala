package com.rkss.rpg.coc.behaviors

import com.rkss.rpg.coc.concepts.internal._
import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.helpers.traits._

private[coc] trait WithValueModificationBehavior[A <: GlobalNameTag] {
  self: WithModificationValue with WithModifiableValue[A] =>

  private var _modification: Int = 0

  override private[coc] def modify(
      modification: ValueModification[A]
  ): ValueModified[A] = {
    val previous = _modification

    val ValueModification(name, value) = modification

    _modification += value

    ValueModified(name, value, _modification, previous)
  }

  override private[coc] def modificationValue: Int = {
    _modification
  }
}
