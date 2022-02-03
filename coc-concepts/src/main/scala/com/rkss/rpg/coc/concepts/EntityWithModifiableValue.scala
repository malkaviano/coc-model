package com.rkss.rpg.coc.concepts

trait EntityWithModifiableValue[A <: NameTag] {
  def modify(modification: ValueModification[A]): ValueModified
}
