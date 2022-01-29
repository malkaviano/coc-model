package com.rkss.rpg.coc.rules.skill.behaviors

import com.rkss.rpg.coc.concepts._

private[coc] trait WithGenericModificationValueBehavior[A] {
  self: EntityWithModificationValue with GenericEntityWithModifiableValue[A] =>

  private var _modification: Int = 0

  override def modify(modification: ValueModification[A]): Unit = {
    _modification += modification.value
  }

  override def modificationValue: Int = {
    _modification
  }
}
