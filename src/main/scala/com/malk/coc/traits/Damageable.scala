package com.malk.coc.traits

trait Damageable {
  def HP: Int

  def HP_=(hp: Int): Unit
}