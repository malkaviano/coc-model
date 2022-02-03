package com.rkss.rpg.coc.concepts

trait EntityWithModifiableValue[A <: NameTag] {
  private[coc] def modify(modification: ValueModification[A]): ValueModified
}
