package com.rkss.rpg.coc.concepts.commons

trait EntityWithNameTag[A <: Naming] {
  def name: A
}
