package com.rkss.rpg.coc.concepts.internal

trait WithModifiableValue[A <: Naming] {
  private[coc] def modify(modification: ValueModification[A]): ValueModified
}
