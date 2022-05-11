package com.rkss.rpg.coc.concepts.internal

import com.rkss.rpg.coc.concepts.results._

trait WithModifiableValue[A <: Naming] {
  private[coc] def modify(modification: ValueModification[A]): ValueModified
}
