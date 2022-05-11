package com.rkss.rpg.coc.concepts.internal

import com.rkss.rpg.coc.concepts.results._
import com.rkss.rpg.helpers.traits._

trait WithModifiableValue[A <: GlobalNameTag] {
  private[coc] def modify(modification: ValueModification[A]): ValueModified[A]
}
