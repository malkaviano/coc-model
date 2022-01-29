package com.rkss.rpg.coc.concepts

trait GenericEntityWithModifiableValue[A] {
  def modify(modification: ValueModification[A]): Unit
}
