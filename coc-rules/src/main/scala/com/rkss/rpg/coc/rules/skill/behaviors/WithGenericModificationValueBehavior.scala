package com.rkss.rpg.coc.rules.skill.behaviors

import com.rkss.rpg.coc.concepts._

private[coc] trait WithGenericModificationValueBehavior[A] {
  self: EntityWithModificationValue with GenericEntityWithModifiableValue[A] =>

  private var _modification: Int = 0

  override def modify(modification: ValueModification[A]): Unit = {
    modification match {
      case ValueModificationIncrease(_, value) =>
        _modification += Math.abs(value)
      case ValueModificationDecrease(_, value) =>
        _modification -= Math.abs(value)
    }
  }

  override def modificationValue: Int = {
    _modification
  }
}
