package com.rkss.rpg.coc.rules.skill.behaviors

import com.rkss.rpg.coc.concepts._

private[coc] trait WithGenericModificationValueBehavior[A <: NameTag] {
  self: EntityWithModificationValue with GenericEntityWithModifiableValue[A] =>

  private var _modification: Int = 0

  override def modify(modification: ValueModification[A]): ValueModified = {
    val previous = _modification

    val (name, modified) = modification match {
      case ValueModificationIncrease(name, value) =>
        (name, Math.abs(value))
      case ValueModificationDecrease(name, value) =>
        (name, -Math.abs(value))
    }

    _modification += modified

    ValueModified(name, modified, _modification, previous)
  }

  override def modificationValue: Int = {
    _modification
  }
}
