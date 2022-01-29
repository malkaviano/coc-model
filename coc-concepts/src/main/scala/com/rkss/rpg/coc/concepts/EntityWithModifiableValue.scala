package com.rkss.rpg.coc.concepts

trait EntityWithModifiableValue {
  def modify(value: Int): Unit
}
