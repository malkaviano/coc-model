package com.rkss.rpg.coc.concepts.internal

trait WithNaming[+A <: Naming] {
  def name: A
}
