package com.rkss.rpg.coc.rules.behaviors

import com.rkss.rpg.coc.concepts._

private[coc] trait WithModificationValueBehavior {
  self: EntityWithModificationValue with ModifiableValue =>

  private var _modification: Int = 0

  override def modify(value: Int): Unit = {
    _modification += value
  }

  override def modificationValue: Int = {
    _modification
  }
}
