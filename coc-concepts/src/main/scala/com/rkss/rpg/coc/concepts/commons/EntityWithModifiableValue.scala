package com.rkss.rpg.coc.concepts.commons

trait EntityWithModifiableValue[A <: Naming] {
  private[coc] def modify(modification: ValueModification[A]): ValueModified
}
