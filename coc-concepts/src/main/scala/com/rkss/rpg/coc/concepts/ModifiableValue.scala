package com.rkss.rpg.coc.concepts

private [coc] trait ModifiableValue {
  def modify(value: Int): Unit
}
