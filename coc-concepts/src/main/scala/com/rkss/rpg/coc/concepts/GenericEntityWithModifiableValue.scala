package com.rkss.rpg.coc.concepts

trait GenericEntityWithModifiableValue[A <: NameTag] {
  def modify(modification: ValueModification[A]): ValueModified
}
